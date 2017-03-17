package com.example.demo.rest.resources;


import com.example.demo.rest.model.Tool;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;


public abstract class ExternalToolResource {

    private static final Client CLIENT = ClientBuilder.newClient().register(new JacksonFeature());
    private static final String ALIAS = "http://ms-alias-tool:8080/tools";
    private static final String TASK = "/task/";


    /**
     * Everis
     * 16Mar17
     * Get all Took associated in the Task.
     *
     * @param taskId
     * @return
     */
    public static List<Tool> find(Integer taskId) {
        return CLIENT.target(ALIAS + TASK + taskId).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Tool>>() {
                });


    }

    /**
     * Everis
     * Get an Tool by Id
     * 16MAR17
     *
     * @param toolId
     * @return
     */
    public static Tool get(Integer toolId) {
        return CLIENT.target(ALIAS + "/" + toolId).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<Tool>() {
                });

    }


}

