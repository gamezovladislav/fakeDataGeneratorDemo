package com.example.fakedatageneratordemo.processor;

import com.example.fakedatageneratordemo.exception.UnknownProcessorCodeException;

import java.util.Arrays;

public enum ProcessorType {
    SIMPLE("1"),
    TRANSFORMER("2"),
    MY_OWN_DATA("3")
    ;

    private final String code;

    ProcessorType(String code) {
        this.code = code;
    }

    public static ProcessorType byCode(String code) {
        return Arrays.stream(values())
                .filter(type -> code.equals(type.code))
                .findFirst()
                .orElseThrow(() -> new UnknownProcessorCodeException(code));
    }
}
