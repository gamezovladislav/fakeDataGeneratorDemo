package com.example.fakedatageneratordemo.exception;

import com.example.fakedatageneratordemo.App;

public class UnknownProcessorCodeException extends AppRuntimeException {

    private static final String MESSAGE_FORMAT = "Processor type by code [ %s ] does not exist.";

    public UnknownProcessorCodeException(String code) {
        super(String.format(MESSAGE_FORMAT, code));
    }
}
