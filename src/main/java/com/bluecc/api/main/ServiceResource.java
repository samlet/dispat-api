package com.bluecc.api.main;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// POST: http://127.0.0.1:8080/services/rest/echo
@Path("/services")
@RequestScoped
public class ServiceResource {
    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim(standard = Claims.birthdate)
    String birthdate;

    /** Check whether map m is empty. */
    public static <K, E> boolean isEmpty(Map<K, E> m) {
        return (m == null) || m.isEmpty();
    }

    @POST
    @Path("rest/{serviceName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPost(HashMap<String, Object> serviceInParams,
                           @PathParam(value = "serviceName") String serviceName)
            throws IOException {
        if (isEmpty(serviceInParams)) {
            throw new BadRequestException("The request body is missing.");
        }
        return Response.ok(serviceInParams).build();
    }
}

