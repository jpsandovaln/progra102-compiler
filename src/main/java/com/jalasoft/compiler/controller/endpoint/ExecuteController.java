package com.jalasoft.compiler.controller.endpoint;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.controller.component.JavaPropeties;
import com.jalasoft.compiler.controller.exception.FileException;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.response.ErrorResponse;
import com.jalasoft.compiler.controller.response.OKResponse;
import com.jalasoft.compiler.controller.service.FileService;
import com.jalasoft.compiler.model.ConvertFacade;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ExecuteException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import com.jalasoft.compiler.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
@RestController
public class ExecuteController {
    @Autowired
    private JavaPropeties javaPropeties;

    @Autowired
    private FileService fileService;

    @PostMapping("/execute")
    public ResponseEntity executeJava(RequestParam param) {
        try {
            param.validate();
            File javaFile = this.fileService.store(param.getFile(), this.javaPropeties.getProjectFolder());
            JavaParameter parameter = new JavaParameter(javaFile,  this.javaPropeties.getVersion8());
            Result result = ConvertFacade.compile(parameter, param.getLang());
            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResultConsonle(), result.getPid())
            );
        } catch (InvalidDataException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        } catch (FileException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        } catch (CommandException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        } catch (ExecuteException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        }
    }
}