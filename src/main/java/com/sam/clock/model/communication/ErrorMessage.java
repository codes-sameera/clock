package com.sam.clock.model.communication;

import lombok.Value;

import java.util.Date;

@Value
public class ErrorMessage {
    int statusCode;
    Date timestamp;
    String message;
    String description;
}
