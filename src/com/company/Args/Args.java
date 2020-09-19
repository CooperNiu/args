package com.company.Args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private Parser parser;
    String args;
    Schema schema;

    public Args(String args, Parser parser) {
        this.args = args;
        this.parser = parser;
    }

    public Args(Schema schema, Parser parser) {
        this.schema = schema;
        this.parser = parser;
    }

    public List<Arg> analyze(){
        List<String> parsedString = parser.parse();
        List<Arg> args = new ArrayList<>();
        parsedString.forEach(item -> {
            String[] split = item.split("\\s+");
            String flag = split[0].substring(1);
            String value = split[1];
            args.add(new Arg(flag, parseValueBy(schema, flag, value)));
        });

        return args;
    }

    private Object parseValueBy(Schema schema, String flag, String value) {
        Object flagType = schema.getFlagType(flag);

        if (flagType.equals(Boolean.class)){
            return Boolean.parseBoolean(value);
        }

        if (flagType.equals(Integer.class)){
            return Integer.parseInt(value);
        }

        return value;
    }

    public Args(String argsText) {
        this.argsText = argsText;
    }

    public List<KeyValuePair> scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        //TODO 学习stream
        //上下两种是等价的，上面是缩写为lambda表达式
        keyValues = keyValues.stream().map(String::trim).collect(Collectors.toList());
//        keyValues = keyValues.stream().map(keyValue -> keyValue.trim()).collect(Collectors.toList());

        keyValues = keyValues.subList(1, keyValues.size());

        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        keyValues.forEach(keyValue -> {
            String[] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            keyValuePairs.add(new KeyValuePair(key, value));
        });
        return keyValuePairs;
    }

    public Object getValueOf(String flag){


        return null;
    }
}
