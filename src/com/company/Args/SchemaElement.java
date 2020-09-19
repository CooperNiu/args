package com.company.Args;

public class SchemaElement {
    private String flag;
    private Object type;

    public SchemaElement(String flag, Object type) {
        this.flag = flag;
        this.type = type;
    }

    public boolean equalsWith(String flag) {
        return flag.equalsIgnoreCase(this.flag);
    }

    public Object getType() {
        return type;
    }

    public Object getFlag() {
        return flag;
    }
}
