package com.company.Args;

public class Arg {
    private String flag;
    private String value;
    private String type;

    public Arg(String argPair, Schema schema) {

    }

    Object parseValue(){
        return new Object();
    }

    boolean withFlag(String flag){
        return true;
    }

    void isArgValid(){
        
    }

    public String getFlag() {
        return flag;
    }
}
