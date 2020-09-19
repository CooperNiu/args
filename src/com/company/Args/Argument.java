package com.company.Args;

public class Argument {
    private final String flag;
    private final Object value;

    public Argument(String flag, Object value) {
        this.flag = flag;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getFlag() {
        return flag;
    }
}
