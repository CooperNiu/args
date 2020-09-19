package com.company.Args;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ArgsTest {
    @Test
    public void should_return_type_when_analyze_given_schema_and_parsed_string() {
        //given
        Set<SchemaElement> schemaElements = new HashSet<>();
        schemaElements.add(new SchemaElement("l", Boolean.class));
        schemaElements.add(new SchemaElement("p", Integer.class));
        schemaElements.add(new SchemaElement("d", String.class));
        Schema schema = new Schema(schemaElements);
        Parser parser = new Parser("-l true -p 8080 -d /usr/logs");
        Args args = new Args(schema, parser);

        //when
        List<Arg> arguments =  args.analyze();

        //then
        assertEquals(3, arguments.size());
        assertEquals(true, arguments.get(0).getValue());
        assertEquals(8080, arguments.get(1).getValue());
        assertEquals("/usr/logs", arguments.get(2).getValue());
    }

    @Test
    public void should_return_string_list_when_scan_given_string(){
        String argsText = "-l true -p 8080 -d uere/logs";

        Args args = new Args(argsText);

        List<KeyValuePair> keyValuePairs = args.scan();

        assertEquals(3, keyValuePairs.size());
        assertEquals(true, keyValuePairs.contains("l true"));
        assertEquals(true, keyValuePairs.contains("p 8080"));
        assertEquals(true, keyValuePairs.contains("d uere/logs"));

    }

    @Test
    public void should_return_value_when_given_args() {
        String argsText = "-l true -p 8080 -d uere/logs";

        Args args = new Args(argsText);

        List<KeyValuePair> keyValuePairs = args.scan();

        assertEquals("true", args.getValueOf("l"));
        assertEquals("8080", args.getValueOf("p"));
        assertEquals("uere/logs", args.getValueOf("d"));
    }


}