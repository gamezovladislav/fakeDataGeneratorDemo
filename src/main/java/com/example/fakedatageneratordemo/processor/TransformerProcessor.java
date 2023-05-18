package com.example.fakedatageneratordemo.processor;

import net.datafaker.Faker;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.sql.SqlDialect;
import net.datafaker.transformations.sql.SqlTransformer;

import static net.datafaker.transformations.Field.field;

public class TransformatorProcessor implements Processor {
    @Override
    public void process() {
        Faker faker = new Faker();
        Schema<String, String> schema = Schema.of(
                field("id", () -> "" + faker.number().positive()),
                field("firstName", () -> faker.name().firstName()),
                field("lastName", () -> faker.name().lastName())
        );
        SqlTransformer<String> transformer =
                new SqlTransformer.SqlTransformerBuilder<String>()
                        .tableName("Fake_person")
                        .dialect(SqlDialect.POSTGRES)
                        .build();
        String output = transformer.generate(schema, 5);
        System.out.println(output);
    }

    @Override
    public ProcessorType getType() {
        return ProcessorType.TYPE_2;
    }
}
