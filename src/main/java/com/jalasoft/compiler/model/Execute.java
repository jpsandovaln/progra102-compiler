package com.jalasoft.compiler.model;

import com.jalasoft.compiler.model.exception.ExecuteException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author HP
 * @version 1.1
 */
public class Execute {
    public String executeJava(String command) throws ExecuteException {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command + "\"");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            process.waitFor();

            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append((char) reader.read());
            }
            return result.toString();

        } catch (IOException ex) {
            throw new ExecuteException(ex);
        } catch (InterruptedException ex) {
            throw new ExecuteException(ex);
        }
    }
}
