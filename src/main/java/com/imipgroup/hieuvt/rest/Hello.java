package com.imipgroup.hieuvt.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by hieu.vutrong on 1/16/2015.
 */

@Component
@Path("/hello")

public class Hello {

    @GET
    @Path("/dummy")
    public Response greet() {
        return Response.status(200).entity("Fuck yeah").build();
    }
}
