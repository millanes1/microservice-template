package com.example.demo.rest.resources;


import com.example.demo.rest.PersistenceHelper;
import com.example.demo.rest.model.Task;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/tasks")
@Api(value = "/tasks", description = "Get task information", tags = "task")
public class TaskResource {

    @Inject
    PersistenceHelper helper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task",
            notes = "Returns task as list",
            response = List.class)
    public Task[] get() {
        List<Task> taskList = new ArrayList<Task>();
        taskList = helper.getEntityManager().createNamedQuery("Task.findAll", Task.class).getResultList();

        for (Task item : taskList) {

            item.setToolList(ExternalToolResource.find(item.getId()));
            if (item.getWorkpackageId() == null)
                continue;
            item.setWorkpackage(ExternalWorkPackageResource.get(item.getWorkpackageId()));


        }
        return taskList.toArray(new Task[0]);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task by Id",
            notes = "Returns task as Object",
            response = List.class)
    public Task get(@PathParam("id") int id) {
        return helper.getEntityManager().createNamedQuery("Task.getById", Task.class).setParameter("id", id).getSingleResult();


    }


    @GET
    @Path("/workpackage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task associated in the workpackage",
            notes = "Returns task as list",
            response = List.class)
    public Task[] findByWorpackageId(@PathParam("id") int id) {

        return helper.getEntityManager().createNamedQuery("Task.findByWorkpackageId", Task.class).setParameter("id", id).getResultList().toArray(new Task[0]);
    }


}

