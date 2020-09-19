package com.company.Args;

import java.util.List;

public class Args {
    private Lexer lexer;
    private ArgumentParser argumentParser;

    public Args(Schema schema, Lexer lexer) {
        this.lexer = lexer;
        argumentParser = new ArgumentParser(schema);
    }

    List<Argument> analyze(String inputCommand) {
        List<String> splitParts = lexer.parse(inputCommand);

        return argumentParser.parse(splitParts);
    }
}
