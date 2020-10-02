package com.jalasoft.compiler.controller.request;

import com.jalasoft.compiler.common.ConfigurationProperty;
import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.common.validation.IValidationStrategy;
import com.jalasoft.compiler.common.validation.LanguageValidation;
import com.jalasoft.compiler.common.validation.MultipartFileValidation;
import com.jalasoft.compiler.common.validation.NotNullOrEmpty;
import com.jalasoft.compiler.common.validation.ValidationContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class RequestParam {
    private String lang;
    private String version;
    private MultipartFile file;

    public RequestParam(String lang, String version, MultipartFile file) {
        this.lang = lang;
        this.version = version;
        this.file = file;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategyList = new ArrayList<>();
        validationStrategyList.add(new NotNullOrEmpty("lang", this.lang));
        validationStrategyList.add(new LanguageValidation(this.lang));
        validationStrategyList.add(new NotNullOrEmpty("version", this.version));
        validationStrategyList.add(new MultipartFileValidation(this.file));

        ValidationContext context = new ValidationContext(validationStrategyList);
        context.validation();
    }
}
