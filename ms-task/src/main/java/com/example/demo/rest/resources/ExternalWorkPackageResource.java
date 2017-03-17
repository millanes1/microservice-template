package com.example.demo.rest.resources;


import com.example.demo.rest.model.WorkPackage;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;


public abstract class ExternalWorkPackageResource {

    private static final Client CLIENT = ClientBuilder.newClient().register(new JacksonFeature());
    private static final String ALIAS = "http://ms-alias-workpackage:8080/workpackages";


    /**
     * Everis
     * Get an WorkPackage by Id
     * 16MAR17
     *
     * @param workPackageId
     * @return
     */
    public static WorkPackage get(Integer workPackageId) {
        return CLIENT.target(ALIAS + "/" + workPackageId).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<WorkPackage>() {
                });

    }


}

