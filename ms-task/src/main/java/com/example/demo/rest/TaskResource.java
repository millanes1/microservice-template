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


@Path("/tasks")
@Api(value = "/tasks", description = "Get task information", tags = "task")
public class TaskResource {

    @Inject
    PersistenceHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all workpackages",
            notes = "Returns task as list",
            response = List.class)
    public Task[] get() { System.out.println("inicio task");

        return helper.getEntityManager().createNamedQuery("Task.findAll", Task.class).getResultList().toArray(new Task[0]);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task get(@PathParam("id") int id) {
        System.out.println("inicio task");

        System.out.println("id out :"+id);
        return helper.getEntityManager().createNamedQuery("Task.getById", Task.class).setParameter("id", id).getSingleResult();
    }


}

