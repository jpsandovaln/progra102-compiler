package com.jalasoft.compiler.controller.endpoint;

import com.jalasoft.compiler.model.Execute;
import com.jalasoft.compiler.model.command.JavaCommand;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ExecuteException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Parameter;

/**
 * @author HP
 * @version 1.1
 */
@RestController
public class ExecuteController {
    @PostMapping("/execute")
    public String executeJava(MultipartFile file) throws CommandException, ExecuteException {
        try {
            /*if(file.getOriginalFilename().contains("..")) {
                throw new
            }*/
            JavaCommand command = new JavaCommand();
            Execute execute = new Execute();
            return execute.executeJava(command.buildCommand());
        } catch (CommandException ex) {
            return ex.getMessage();
        } catch (ExecuteException ex) {
            return ex.getMessage();
        }
    }
}