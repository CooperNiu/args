package com.company.Args;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class SchemaTest {
    @Test(expected = FlagNotDefinedException.class)
    public void should_throw_exception_when_get_flag_type_given_flag_not_exist_in_schema_definition(){
        Set<SchemaElement> schemaElements = new HashSet<>();
        schemaElements.add(new SchemaElement("l", Boolean.TYPE));
        Schema schema = new Schema(schemaElements);

        schema.getFlagType("p");
    }

    @Test
    public void should_return_boolean_when_get_type_given_flag(){
        Set<SchemaElement> schemaElements = new HashSet<>();
        schemaElements.add(new SchemaElement("l", Boolean.TYPE));
        schemaElements.add(new SchemaElement("p", Integer.TYPE));
        schemaElements.add(new SchemaElement("d", String.class.getSimpleName()));

        System.out.println(String.class.getSimpleName());
        Schema schema = new Schema(schemaElements);

        Assert.assertEquals(Boolean.TYPE, schema.getFlagType("l"));
        Assert.assertEquals(Integer.TYPE, schema.getFlagType("p"));
        Assert.assertEquals(String.class.getSimpleName(), schema.getFlagType("d"));
    }
}