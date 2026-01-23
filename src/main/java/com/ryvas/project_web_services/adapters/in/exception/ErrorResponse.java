package com.ryvas.project_web_services.adapters.in.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer statusCode;

}
