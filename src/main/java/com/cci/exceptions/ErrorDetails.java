package com.cci.exceptions;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cci.enums.CustomStatusCode;

@Data
@Accessors(chain = true)
public class ErrorDetails {

    private  Map<String, String> errors = new HashMap<String, String>();
    private Date timestamp;
    private String details;
    private String message;
    private int statusCode;

    public ErrorDetails(Date timestamp, String message, String details, Map<String, String> errors) {
        super();
        this.timestamp = timestamp;
        this.details = details;
        this.message = message;
        this.errors = errors;
    }

    public ErrorDetails(Date date, String message, String description, int code) {
        super();
        this.timestamp = date;
        this.details = description;
        this.message = message;
        this.statusCode = code;
    }
    
    public ErrorDetails(Date date, String message, CustomStatusCode code) {
        super();
        this.timestamp = date;
        this.details = code.getExceptionDescription();
        this.message = message;
        this.statusCode = code.getCode();
    }
}
