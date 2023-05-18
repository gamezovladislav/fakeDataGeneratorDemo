package com.example.fakedatageneratordemo.exception;

import com.example.fakedatageneratordemo.processor.ProcessorType;

public class UnknownProcessorException extends AppRuntimeException {

    public static final String MESSAGE_FORMAT = "Processor by type [ %s ] does not exist.";

    public UnknownProcessorException(ProcessorType type) {
        super(String.format(MESSAGE_FORMAT, type.name()));
    }
}
