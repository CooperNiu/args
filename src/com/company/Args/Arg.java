package com.company.Args;

public class Arg {
    private String flag;
    private Object value;
    private String type;

    public Arg(String argPair, Schema schema) {

    }

    public Arg(String flag, Object value) {
        this.flag = flag;
        this.value = value;
    }

    public Object getValue(){
        return value;
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
