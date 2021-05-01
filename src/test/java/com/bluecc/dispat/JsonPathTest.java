package com.bluecc.dispat;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

public class JsonPathTest {
    @Test
    public void testPath(){
        Configuration.setDefaults(new Configuration.Defaults() {

            private final JsonProvider jsonProvider = new JacksonJsonProvider();
            private final MappingProvider mappingProvider = new JacksonMappingProvider();

            @Override
            public JsonProvider jsonProvider() {
                return jsonProvider;
            }

            @Override
            public MappingProvider mappingProvider() {
                return mappingProvider;
            }

            @Override
            public Set<Option> options() {
                return EnumSet.noneOf(Option.class);
            }
        });

        String json = "{\n" +
                "  \"statusCode\": 200,\n" +
                "  \"statusDescription\": \"OK\",\n" +
                "  \"data\": {\n" +
                "    \"orderId\": \"10020\"\n" +
                "  }\n" +
                "}";
//        Configuration conf=Configuration.defaultConfiguration().jsonProvider(new GsonJsonProvider());
//        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
//        Object document = new GsonJsonProvider().parse(json);
//        String orderId = JsonPath.read(document, "$.data.orderId");
        String orderId = JsonPath.parse(json).read("$.data.orderId");
        System.out.println(orderId);
    }
}
