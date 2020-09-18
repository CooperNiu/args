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

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
