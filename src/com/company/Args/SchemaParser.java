package com.company.Args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchemaParser {
    private String inputSchema;

    SchemaParser(String inputSchema) {
        this.inputSchema = inputSchema;
    }

    List<SchemaElement> parse() {
        String SCHEMA_DELIMITER = ",";
        String[] split = inputSchema.split(SCHEMA_DELIMITER);

        List<SchemaElement> schemaElements = new ArrayList<>();
        Arrays.asList(split)
                .forEach(schema -> schemaElements.add(parseSchemaElement(schema)));

        return schemaElements;
    }

    private SchemaElement parseSchemaElement(String schema) {
        String SCHEMA_ELEMENT_DELIMITER = ":";
        String[] split = schema.split(SCHEMA_ELEMENT_DELIMITER);
        String flag = split[0];
        String type = split[1];

        return new SchemaElement(flag, findMatchedTypeBy(type));
    }

    private Object findMatchedTypeBy(String type) {
        if ("boolean".equalsIgnoreCase(type)) {
            return Boolean.class;
        }

        if ("integer".equalsIgnoreCase(type)) {
            return Integer.class;
        }

        return String.class;
    }
}