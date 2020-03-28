package com.java.assistencia.controller.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class ApiErrorsList extends ApiErrors {

    private List<String> errors;
    public ApiErrorsList(int code, String msg, Date date, List<String> errors) {
        super(code, msg, date);
        this.errors = errors;
    }
}
