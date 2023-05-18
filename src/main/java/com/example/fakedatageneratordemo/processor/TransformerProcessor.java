package com.example.fakedatageneratordemo.processor;

import net.datafaker.Faker;
import net.datafaker.transformations.CsvTransformer;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.sql.SqlDialect;
import net.datafaker.transformations.sql.SqlTransformer;

import java.util.Scanner;

import static net.datafaker.transformations.Field.field;

public class TransformerProcessor implements Processor {
    @Override
    public void process() {
        Faker faker = new Faker();
        Schema<String, ?> schema = Schema.of(
                field("id", () -> "" + faker.number().positive()),
                field("firstName", () -> faker.name().firstName()),
                field("lastName", () -> faker.name().lastName())
        );

        boolean f = true;
        Scanner in = new Scanner(System.in);

        while (f) {
            System.out.println("type? :");
            String type = in.nextLine();
            if ("sql".equals(type)) {
                sql(schema);
            } else if ("csv".equals(type)) {
                csv(schema);
            } else if ("exit".equals(type)) {
                f = false;
            }
        }
    }

    @Override
    public ProcessorType getType() {
        return ProcessorType.TRANSFORMER;
    }

    private void sql(Schema<?, ?> schema) {
        SqlTransformer<String> transformer =
                new SqlTransformer.SqlTransformerBuilder<String>()
                        .tableName("Fake_person")
                        .batch(4)
                        .dialect(SqlDialect.POSTGRES)
                        .build();
        String output = transformer.generate((Schema<String, ?>) schema, 5);
        System.out.println(output);
    }

    private void csv(Schema<?, ?> schema) {
        CsvTransformer<Object> transformer = CsvTransformer.builder()
                .separator(" -- ")
                .header(true)
                .build();
        String output = transformer.generate((Schema<Object, ?>) schema, 5);
        System.out.println(output);
    }
}
