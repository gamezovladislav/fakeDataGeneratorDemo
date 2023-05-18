package com.example.fakedatageneratordemo.processor;

public class MyOwnDataProcessor implements Processor {

    @Override
    public void process() {

    }

    @Override
    public ProcessorType getType() {
        return ProcessorType.MY_OWN_DATA;
    }
}
