package com.jalasoft.compiler.controller.endpoint;

import com.jalasoft.compiler.controller.component.JavaPropeties;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.response.ErrorResponse;
import com.jalasoft.compiler.controller.response.OKResponse;
import com.jalasoft.compiler.controller.response.Response;
import com.jalasoft.compiler.controller.service.FileService;
import com.jalasoft.compiler.model.Execute;
import com.jalasoft.compiler.model.command.ICommandBuilder;
import com.jalasoft.compiler.model.command.JavaCommand;
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
            ICommandBuilder<JavaParameter> command = new JavaCommand();
            String commandResult = command.buildCommand(parameter);
            Execute execute = new Execute();
            Result result = execute.executeJava(commandResult);
            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResultConsonle(), result.getPid())
            );
        } catch (CommandException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        } catch (ExecuteException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST), ex.getMessage())
            );
        }
    }
}