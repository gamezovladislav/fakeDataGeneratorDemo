package com.example.fakedatageneratordemo;

import com.example.fakedatageneratordemo.processor.ProcessorManager;

public class App {

    public static void main(String[] args) {
        Starter starter = new Starter(new ProcessorManager());
        starter.start();
    }
}
