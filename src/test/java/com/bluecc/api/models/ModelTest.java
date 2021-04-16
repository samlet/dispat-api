package com.bluecc.api.models;

import com.bluecc.api.models.party.party.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class ModelTest {
    @Test
    public void loadPersons() throws IOException {
        Gson gson= new GsonBuilder().create();
        URL resource=ModelTest.class.getResource("/seeds/Person.json");
        String json=IOUtils.toString(resource, StandardCharsets.UTF_8);
        Person[] dataList= gson.fromJson(json, Person[].class);
        Arrays.stream(dataList).forEach(d -> System.out.println(d));
    }
}
