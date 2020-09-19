package com.company.Args;

import com.company.Args.Exception.FlagDuplicationException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ArgsTest {
    private Args args;

    @Before
    public void setUp() {
        //given
        Set<SchemaElement> schemaElements = new HashSet<>();
        schemaElements.add(new SchemaElement("l", Boolean.class));
        schemaElements.add(new SchemaElement("p", Integer.class));
        schemaElements.add(new SchemaElement("d", String.class));
        Schema schema = new Schema(schemaElements);
        Lexer lexer = new Lexer();
        args = new Args(schema, lexer);
    }

    @Test
    public void should_return_type_when_analyze_given_schema_and_parsed_string() {
        //when
        List<Argument> arguments =  args.analyze("-l true -p 8080 -d /usr/logs");

        //then
        assertEquals(3, arguments.size());
        assertEquals(true, arguments.get(0).getValue());
        assertEquals(8080, arguments.get(1).getValue());
        assertEquals("/usr/logs", arguments.get(2).getValue());
    }

    @Test
    public void should_return_default_type_when_analyze_given_schema_and_parsed_string_without_type() {
        //when
        List<Argument> arguments =  args.analyze("-l -p 8080 -d /usr/logs");

        //then
        assertEquals(3, arguments.size());
        assertEquals(false, arguments.get(0).getValue());
        assertEquals(8080, arguments.get(1).getValue());
        assertEquals("/usr/logs", arguments.get(2).getValue());
    }

    @Test(expected = FlagDuplicationException.class)
    public void should_throw_flag_duplication_exception_when_analyze_given_schema_and_parsed_string_with_duplicated_flag() {
        //when
        args.analyze("-p 8080 -p 2020");
    }
}
