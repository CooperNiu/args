package com.company.Args;

import com.company.Args.Exception.EmptyStringException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String source;

    public Parser(String source) {
        this.source = source;
    }

    public List<String> parse() {
        // Returns true if the string is empty
        // or contains only white space codepoints,
        // otherwise false.
        if (source.isBlank()) {
            throw new EmptyStringException();
        }

        return parseNonEmptyString();
    }

    private List<String> parseNonEmptyString() {
        // regex expression to read string starting with "-" + one char + several space + string
        String PARSE_REGEX = "\\-[a-zA-Z]\\s+\\S+";
        List<String> result = new ArrayList<>();

        Matcher matcher = Pattern.compile(PARSE_REGEX).matcher(source);

        while (matcher.find()){
            result.add(matcher.group());
        }

        return result;
    }
}
