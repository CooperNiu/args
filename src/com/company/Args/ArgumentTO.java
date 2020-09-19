package com.company.Args;

public class ArgumentTO {
    String flag;
    private final String value;

    public ArgumentTO(String flag, String value) {
        this.flag = flag;
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public String getValue() {
        return value;
    }
}
