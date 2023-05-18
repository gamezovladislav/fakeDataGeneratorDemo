package com.example.fakedatageneratordemo;

import com.example.fakedatageneratordemo.exception.AppException;
import com.example.fakedatageneratordemo.exception.AppRuntimeException;
import com.example.fakedatageneratordemo.processor.Processor;
import com.example.fakedatageneratordemo.processor.ProcessorManager;

import java.util.Scanner;

public class Starter {


    public static final String FINISH_MESSAGE = "-1";

    private ProcessorManager processorManager;

    public Starter(ProcessorManager processorManager) {
        this.processorManager = processorManager;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        String message;
        while (!FINISH_MESSAGE.equals(message = in.nextLine())) {
            try {
                Processor processor = processorManager.getProcessor(message);
                System.out.println("Result:\n");
                processor.process();
                System.out.println("------------------------------------\n");
            } catch (AppRuntimeException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
