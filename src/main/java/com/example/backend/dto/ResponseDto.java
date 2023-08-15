package com.example.backend.dto;

public class ResponseDto {

    private String errorMessage;
    private String code;
    private String response;

    public ResponseDto(String errorMessage, String code, String response) {
        this.errorMessage = errorMessage;
        this.code = code;
        this.response = response;
    }

    public ResponseDto() {
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
