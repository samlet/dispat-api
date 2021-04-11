package com.bluecc.api;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

public class GenerateToken {
    /**
     * Generate JWT token
     * Add VM parameters: -Dexec.classpathScope=main -Dsmallrye.jwt.sign.key-location=privateKey.pem
     */
    public static void main(String[] args) {
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .upn("jdoe@quarkus.io")
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim(Claims.birthdate.name(), "2001-07-13")
                        .sign();
        System.out.println(token);

        // smallrye.jwt.new-token.lifespan 300
        //Token lifespan in seconds which will be used to calculate an exp (expiry)
        // claim value if this claim has not already been set.
    }
}