package com.company.Args;

import java.util.Set;

public class Schema {

    Object type;
    private String[]  schema = {"l", "p", "d"};
    private boolean lValue = false;
    private int pValue = 8080;
    private String dValue = "";
    private Set<FlagSchema> flagSchemas;

    public Schema(Set<FlagSchema> flagSchemas) {
        this.flagSchemas = flagSchemas;
    }

    public Object getType(String flag) {
        return flagSchemas.stream()
                .filter(flagSchema -> flagSchema.equalsWith(flag))
                .findFirst()
                .get()
                .getType();
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String[] getSchema() {
        return schema;
    }

    public void setSchema(String[] schema) {
        this.schema = schema;
    }

    public boolean islValue() {
        return lValue;
    }

    public void setlValue(boolean lValue) {
        this.lValue = lValue;
    }

    public int getpValue() {
        return pValue;
    }

    public void setpValue(int pValue) {
        this.pValue = pValue;
    }

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }
}
