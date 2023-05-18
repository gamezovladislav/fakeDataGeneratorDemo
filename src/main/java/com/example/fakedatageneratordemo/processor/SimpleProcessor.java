package com.example.fakedatageneratordemo.processor;

import net.datafaker.Faker;

public class SimpleProcessor implements Processor {


    @Override
    public void process() {
        Faker faker = new Faker();
        print("name         ", faker.harryPotter().character());
        print("address      ", faker.address().fullAddress());
        print("job.title    ", faker.job().title());
        print("job.position ", faker.job().position());
        print("job.field    ", faker.job().field());
        print("phone        ", faker.phoneNumber().phoneNumberInternational());
        print("videoGame    ", faker.videoGame().title() + " (g: " + faker.videoGame().genre() + " , p: " + faker.videoGame().platform());
        print("numerify     ", faker.numerify("kj?h?D?B?S?###FNA"));
        print("letterify    ", faker.letterify("kj?h?D?B?S?###FNA"));
        print("bothify      ", faker.bothify("kj?h?D?B?S?###FNA"));
    }

    @Override
    public ProcessorType getType() {
        return ProcessorType.SIMPLE;
    }

    private void print(String key, String value) {
        System.out.println(key + ": " + value);
    }
}
