package com.company.Args;

import com.company.Args.Exception.FlagNotDefinedException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Schema {

    Object type;
    private String[]  schema = {"l", "p", "d"};
    private boolean lValue = false;
    private int pValue = 8080;
    private String dValue = "";
    private Set<SchemaElement> schemaElements;

    public Schema(Set<SchemaElement> schemaElements) {
        this.schemaElements = schemaElements;
    }

    public Object getFlagType(String flag) {
        List<SchemaElement> schemaElements = findElementByFlag(flag);
        boolean flagNotExist = schemaElements.size() == 0;

        if (flagNotExist){
            throw new FlagNotDefinedException();
        }

        SchemaElement matchedElement = schemaElements.get(0);

        return matchedElement.getType();
    }

    private List<SchemaElement> findElementByFlag(String flag) {
        return schemaElements.stream()
                .filter(schemaElement -> schemaElement.getFlag().equals(flag))
                .collect(Collectors.toList());
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
