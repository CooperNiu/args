package com.company.Args;

import com.company.Args.Exception.EmptyStringException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexerTest {
    private List<String> parseByLexer(String source) {
        //given
        Lexer lexer = new Lexer();

        //when
        return lexer.parse(source);
    }

    @Test
    public void should_return_list_with_one_element_when_parse_given_one_flag_value() {
        List<String> result = parseByLexer("-l true");

        //then
        assertEquals(1, result.size());
        assertEquals("-l true", result.get(0));
    }

    @Test
    public void should_return_list_with_multiple_elements_when_parse_given_multiple_flag_value() {
        //given
        List<String> result = parseByLexer("-l true -p 8080 -d /usr/logs");

        //then
        assertEquals(3, result.size());
        assertEquals("-l true", result.get(0));
        assertEquals("-p 8080", result.get(1));
        assertEquals("-d /usr/logs", result.get(2));
    }

    @Test
    public void should_return_list_with_multiple_elements_when_parse_given_flag_with_value_is_empty() {
        //given
        List<String> result = parseByLexer("-l -p 8080 -d /usr/logs");

        //then
        assertEquals(3, result.size());
        assertEquals("-l", result.get(0));
        assertEquals("-p 8080", result.get(1));
        assertEquals("-d /usr/logs", result.get(2));
    }

    @Test
    public void should_return_list_when_parse_given_flag_value_with_empty_space_between() {
        //given
        List<String> result = parseByLexer("    -l  true ");

        //then
        assertEquals(1, result.size());
        assertEquals("-l  true", result.get(0));
    }

    @Test
    public void should_return_list_when_parse_given_flag_value_with_empty_space_at_start_and_end() {
        //given
        List<String> result = parseByLexer("    -l  true ");

        //then
        assertEquals(1, result.size());
        assertEquals("-l  true", result.get(0));
    }

    @Test(expected = EmptyStringException.class)
    public void should_throw_exception_when_parse_given_empty_string() {
        //given
        String source = " ";
        Lexer lexer = new Lexer();

        //when
        lexer.parse(source);
    }
}
