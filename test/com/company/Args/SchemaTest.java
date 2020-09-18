package com.company.Args;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class SchemaTest {
    @Test
    public void should_return_boolean_when_get_type_given_flag(){
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("p", Integer.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class.getSimpleName()));

        System.out.println(String.class.getSimpleName());
        Schema schema = new Schema(flagSchemas);

        Object type = schema.getType("l");

        Assert.assertEquals(Boolean.TYPE, schema.getType("l"));
        Assert.assertEquals(Integer.TYPE, schema.getType("p"));
        Assert.assertEquals(String.class.getSimpleName(), schema.getType("d"));
    }

    @Test
    public void should_return_integar_when_get_type_given_flag(){
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("p", Integer.TYPE));

        System.out.println(String.class.getSimpleName());
        Schema schema = new Schema(flagSchemas);

        Assert.assertEquals(Integer.TYPE, schema.getType("p"));
    }

    @Test
    public void should_return_string_when_get_type_given_flag(){
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("d", String.class.getSimpleName()));

        System.out.println(String.class.getSimpleName());
        Schema schema = new Schema(flagSchemas);

        Assert.assertEquals(String.class.getSimpleName(), schema.getType("d"));
    }
}