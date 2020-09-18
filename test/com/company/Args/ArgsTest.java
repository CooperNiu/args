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

        List<KeyValuePair> keyValueString = args.scan();

        assertEquals(3, keyValueString.size());
        assertEquals(true, keyValueString.contains("l true"));
        assertEquals(true, keyValueString.contains("p 8080"));
        assertEquals(true, keyValueString.contains("d uere/logs"));

    }

    @Test
    public void getValueOf() {
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