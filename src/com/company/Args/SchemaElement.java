package com.company.Args;

public class SchemaElement {
    private final String flag;
    private final Object type;

    public SchemaElement(String flag, Object type) {
        this.flag = flag;
        this.type = type;
    }

    String getFlag() {
        return flag;
    }

    Object getType() {
        return type;
    }
}
