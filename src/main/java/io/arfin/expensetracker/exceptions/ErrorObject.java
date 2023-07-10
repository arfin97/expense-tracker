package io.arfin.expensetracker.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorObject {

    private Integer statusCode;
    private String message;
    private LocalDateTime timeStamp;
}
