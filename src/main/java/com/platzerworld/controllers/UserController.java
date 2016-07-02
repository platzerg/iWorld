package com.platzerworld.controllers;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by com.platzerworld on 26.03.16.
 */
@Path("users")
public class UserController {


    @Path("all")
    @GET
    @Produces("application/json")
    public JsonArray getAllUsers() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonArray usersJson = jsonArrayBuilder.build();

        System.out.println(usersJson.toString());

        return usersJson;
    }
}
