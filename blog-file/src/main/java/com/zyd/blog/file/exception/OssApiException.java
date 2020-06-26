package com.zyd.blog.file.exception;


public class OssApiException extends GlobalFileException {

    public OssApiException(String message) {
        super(message);
    }

    public OssApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
