package com.bluecc.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static com.bluecc.api.JsonUtil.pretty;
import static org.junit.Assert.*;

public class MetaPackageTest {

    @Test
    public void getClasses() throws JsonProcessingException {
        MetaPackage pkg=new MetaPackage("com.bluecc.pay.modules");
        System.out.println(pretty(pkg.getClasses()));
    }
}