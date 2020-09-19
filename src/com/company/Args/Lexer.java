package com.company.Args;


import com.company.Args.Exception.EmptyStringException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    List<String> parse(String source) {
        if (source.isEmpty() || source.trim().isEmpty()) {
            throw new EmptyStringException();
        }

        return parseNonEmptyString(source);
    }

    private List<String> parseNonEmptyString(String source) {
        String PARSE_REGEX = "(?:\\-[a-zA-Z]\\s+[^\\-]\\S+)|(?:\\-[a-zA-Z]\\s+)";
        List<String> splitParts = new ArrayList<>();

        Matcher matcher = Pattern.compile(PARSE_REGEX)
                .matcher(source);

        while (matcher.find()) {
            splitParts.add(matcher.group().trim());
        }

        return splitParts;
    }
}
