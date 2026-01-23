package com.ryvas.project_web_services.adapters.in.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer statusCode;

}
