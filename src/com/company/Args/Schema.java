package com.company.Args;


import com.company.Args.Exception.FlagNotDefinedException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Schema {
    private Set<SchemaElement> schemaElements;

    public Schema(Set<SchemaElement> schemaElements) {
        this.schemaElements = schemaElements;
    }

    Object getFlagType(String flag) {
        List<SchemaElement> elementsByFlag = findElementByFlag(flag);
        boolean flagNotExist = elementsByFlag.size() == 0;

        if (flagNotExist) {
            throw new FlagNotDefinedException();
        }

        SchemaElement matchedElement = elementsByFlag.get(0);
        return matchedElement.getType();
    }

    private List<SchemaElement> findElementByFlag(String flag) {
        return schemaElements.stream()
                .filter(element -> element.getFlag().equals(flag))
                .collect(Collectors.toList());
    }
}
