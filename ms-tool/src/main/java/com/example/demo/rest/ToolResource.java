package com.example.demo.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/tools")
@Api(value = "/tools", description = "Get tools information", tags = "tools")
public class ToolResource {

    @Inject
    PersistenceHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all tool",
            notes = "Returns tool as list",
            response = List.class)
    public Tool[] get() {
        System.out.println("inicio tool");

        return helper.getEntityManager().createNamedQuery("Tool.findAll", Tool.class).getResultList().toArray(new Tool[0]);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tool get(@PathParam("id") int id) {
        System.out.println("inicio tool");

        System.out.println("id out :" + id);
        return helper.getEntityManager().createNamedQuery("Tool.getById", Tool.class).setParameter("id", id).getSingleResult();
    }


}

