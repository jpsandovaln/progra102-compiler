package com.jalasoft.compiler.controller.request;

import com.jalasoft.compiler.common.ConfigurationProperty;
import org.springframework.web.multipart.MultipartFile;

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

    public void validate() throws Exception {
        /*if(file.getOriginalFilename().contains("..")) {
                throw new
         }*/
        if (this.getLang() == null || "".equals(this.getLang())) {
            throw new Exception("failed");
        }

        if (!ConfigurationProperty.getLanguages().contains(this.lang)) {
            throw new Exception("invalid language");
        }
        if (this.getVersion() == null || "".equals(this.getVersion())) {
            throw new Exception("failed");
        }

        if (this.getFile().getOriginalFilename().contains("..")) {
            throw new Exception("failed");
        }
    }
}
