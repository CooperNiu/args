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

}