package com.company.Args;

import org.junit.Test;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;

import static org.junit.Assert.*;

public class ArgsTest {
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

    @Test
    public void mapToArgPais() {
    }

    @Test
    public void isStartWithFlag() {
    }

    @Test
    public void ifFlagDistingct() {
    }
}