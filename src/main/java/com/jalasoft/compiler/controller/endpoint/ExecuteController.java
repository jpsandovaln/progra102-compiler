package com.jalasoft.compiler.controller.endpoint;

import com.jalasoft.compiler.controller.component.JavaPropeties;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.service.FileService;
import com.jalasoft.compiler.model.Execute;
import com.jalasoft.compiler.model.command.JavaCommand;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ExecuteException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import com.jalasoft.compiler.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Result executeJava(RequestParam param) throws CommandException, ExecuteException, Exception {
        try {
            param.validate();
            File javaFile = this.fileService.store(param.getFile(), this.javaPropeties.getProjectFolder());
            JavaParameter parameter = new JavaParameter(javaFile,  this.javaPropeties.getVersion8());
            JavaCommand command = new JavaCommand();
            Execute execute = new Execute();
            return execute.executeJava(command.buildCommand(parameter));
        } catch (CommandException ex) {
            throw ex;
        } catch (ExecuteException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
}