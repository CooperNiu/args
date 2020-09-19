package com.company.Args;

import com.company.Args.Exception.FlagNotDefinedException;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SchemaTest {
    @Test
    public void should_return_flag_type_when_get_flag_type_given_schema() {
        //given
        Set<SchemaElement> schemaElements = new HashSet<>();
        schemaElements.add(new SchemaElement("l", Boolean.class));
        schemaElements.add(new SchemaElement("p", Integer.class));
        schemaElements.add(new SchemaElement("d", String.class));
        Schema schema = new Schema(schemaElements);

        //when

        //then
        assertEquals(Boolean.class, schema.getFlagType("l"));
        assertEquals(Integer.class, schema.getFlagType("p"));
        assertEquals(String.class, schema.getFlagType("d"));
    }

    @Test(expected = FlagNotDefinedException.class)
    public void should_throw_exception_when_get_flag_type_given_flag_not_exist_in_schema_definition() {
        //given
        Set<SchemaElement> schemaElements = new HashSet<>();
        schemaElements.add(new SchemaElement("l", Boolean.class));
        Schema schema = new Schema(schemaElements);

        //when

        //then
        schema.getFlagType("p");
    }
}
