package com.company.Args;

import java.util.Set;

public class Schema {

    Arg arg;
    Object type;

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

}
