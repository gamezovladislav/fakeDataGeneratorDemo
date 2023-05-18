package com.example.fakedatageneratordemo.processor;

import com.example.fakedatageneratordemo.exception.UnknownProcessorException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessorManager {

    private final Map<ProcessorType, Processor> processors;

    public ProcessorManager() {
        this(getDefaultManagers());
    }

    public ProcessorManager(List<Processor> processors) {
        this.processors = processors.stream()
                .collect(Collectors.toMap(Processor::getType, Function.identity()));
    }

    public Processor getProcessor(String code) {
        return getProcessor(ProcessorType.byCode(code));
    }

    public Processor getProcessor(ProcessorType type) {
        Processor processor = processors.get(type);
        if (processor == null) {
            throw new UnknownProcessorException(type);
        }
        return processor;
    }

    private static List<Processor> getDefaultManagers() {
        return List.of(
                new SimpleProcessor(),
                new TransformerProcessor(),
                new MyOwnDataProcessor()
        );
    }

}
