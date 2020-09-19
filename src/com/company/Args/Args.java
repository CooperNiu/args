package com.company.Args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    List<Arg> argPairs;
    String args;
    Schema schema;

    public Args(String args, Schema schema) {
        this.args = args;
        this.schema = schema;
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
