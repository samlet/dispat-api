package com.bluecc.api;

import com.bluecc.api.tests.TokenUtils;
import org.eclipse.microprofile.jwt.Claims;
import org.jose4j.jwt.JwtClaims;
import org.junit.Test;

import java.util.Arrays;

public class JwtTest {
    @Test
    public void testJwt() throws Exception {
        String email="samlet@bluecc.com";
        String username="samlet";
        String birthdate="1999-09-12";

        System.out.println("creating account");

        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setIssuer("https://quarkus.io/using-jwt-rbac");
        jwtClaims.setJwtId("a-123");
        jwtClaims.setSubject(email);
        jwtClaims.setClaim(Claims.upn.name(), email);
        jwtClaims.setClaim(Claims.preferred_username.name(), username);
        jwtClaims.setClaim(Claims.birthdate.name(), birthdate);
        jwtClaims.setClaim(Claims.groups.name(), Arrays.asList(TokenUtils.ROLE_USER));
        jwtClaims.setAudience("using-jwt");
        jwtClaims.setExpirationTimeMinutesInTheFuture(1);

        String token = TokenUtils.generateTokenString(jwtClaims);

        System.out.println(token);
    }
}
