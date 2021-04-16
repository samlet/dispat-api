package com.bluecc.dispat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.Test;

public class RestServices {
    @Test
    public void testFinder(){
        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post("https://localhost:8443/rest/services/performFindList")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyTG9naW5JZCI6ImFkbWluIiwiaXNzIjoiQXBhY2hlT0ZCaXoiLCJleHAiOjE2MzQ1OTc3NTcsImlhdCI6MTYxNjU5Nzc1N30.Luuf2bK7ZJ8KE_CtsA3iPZ189i-Qbm2qK5r5VfeQcJqIyTKy4DHf2fBAp37W8OtU6SIplwCdnbTMtHuCZ5h8cA")
                .body("{\n\t\"entityName\":\"Product\",\n\t\"viewIndex\": 0,\n\t\"viewSize\": 10,\n\t\"inputFields\":{\n\t\t\"productId\": \"10014\"\t\n\t}\n}\n")
                .asString();
        if(response.isSuccess()) {
            System.out.println(response.getBody());
        }
    }
}
