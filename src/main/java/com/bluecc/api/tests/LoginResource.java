package com.bluecc.api.tests;

import com.bluecc.api.Message;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/register")
@RequestScoped
public class LoginResource {

	@Inject
	TokenService tokenService;

	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@QueryParam("email") String email,
						   @QueryParam("username") String username,
						   @QueryParam("birthdate") String birthdate) {

		String token = tokenService.generate(email, username, birthdate);

		return Response.ok(new Message(token)).build();
	}

}
