package com.company.Args;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void should_return_list_with_one_element_when_parse_given_one_flag_value(){
        Parser parser = new Parser("-l true");

        List<String > result = parser.parse();

        assertEquals(1, result.size());
        assertEquals("-l true", result.get(0));
    }

    @Test
    public void should_return_list_with_mutiple_elements_when_parse_given_mutiple_flag_value(){
        Parser parser = new Parser("-l true -p 8080 -d /usr/logs");

        List<String > result = parser.parse();

        assertEquals(3, result.size());
        assertEquals("-l true", result.get(0));
        assertEquals("-p 8080", result.get(1));
        assertEquals("-d /usr/logs", result.get(2));
    }

    @Test
    public void should_return_list_when_parse_given_flag_value_with_empty_space_between(){
        Parser parser = new Parser("     -l true");

        List<String> result = parser.parse();

        assertEquals(1, result.size());
        assertEquals("-l true", result.get(0));
    }
}