package com.example.fakedatageneratordemo.processor;

import net.datafaker.Faker;
import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

import java.nio.file.Paths;
import java.util.Locale;

public class MyOwnDataProcessor implements Processor {

    @Override
    public void process() {
        MyOwnDataFaker faker = new MyOwnDataFaker();
        System.out.println("Fib number : " + faker.data().fib());
        System.out.println("Polish king/queen : " + faker.data().name());
    }

    @Override
    public ProcessorType getType() {
        return ProcessorType.MY_OWN_DATA;
    }

    public static class MyOwnDataProvider extends AbstractProvider<BaseProviders> {

        String KEY = "demo";

        protected MyOwnDataProvider(BaseProviders faker) {
            super(faker);
            faker.addPath(Locale.ENGLISH, Paths.get("src/main/resources/data.yml"));
        }

        public String name() {
            return resolve(KEY + ".names");
        }

        public String fib() {
            return resolve(KEY + ".fib");
        }
    }

    public static class MyOwnDataFaker extends Faker {
        public MyOwnDataProvider data() {
            return getProvider(MyOwnDataProvider.class, MyOwnDataProvider::new, this);
        }
    }
}
