package com.company.Args;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SchemaParserTest {
    @Test
    public void should_return_parsed_schema_element_when_parse_given_one_schema_string() {
        //given
        SchemaParser schemaParser = new SchemaParser("l:boolean");

        //when
        List<SchemaElement> schemaElements = schemaParser.parse();

        //then
        assertEquals(1, schemaElements.size());
        assertEquals("l", schemaElements.get(0).getFlag());
        assertEquals(Boolean.class, schemaElements.get(0).getType());
    }

    @Test
    public void should_return_parsed_schema_elements_when_parse_given_multiple_schema_string() {
        //given
        SchemaParser schemaParser = new SchemaParser("l:boolean,p:integer,d:string");

        //when
        List<SchemaElement> schemaElements = schemaParser.parse();

        //then
        assertEquals(3, schemaElements.size());
        assertEquals("l", schemaElements.get(0).getFlag());
        assertEquals(Boolean.class, schemaElements.get(0).getType());
        assertEquals("p", schemaElements.get(1).getFlag());
        assertEquals(Integer.class, schemaElements.get(1).getType());
        assertEquals("d", schemaElements.get(2).getFlag());
        assertEquals(String.class, schemaElements.get(2).getType());
    }
}
