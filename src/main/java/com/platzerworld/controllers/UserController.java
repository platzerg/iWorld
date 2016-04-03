package com.platzerworld.controllers;


import com.platzerworld.entities.Movie;
import com.platzerworld.entities.RatingService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by com.platzerworld on 26.03.16.
 */
@Path("users")
public class UserController {

    @Inject
    private RatingService ratingService;

    @Path("all")
    @GET
    @Produces("application/json")
    public JsonArray getAllUsers() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        List<Movie> restult = ratingService.movieRating("");

        for(Movie user: restult) {
            jsonArrayBuilder.add(
                    Json.createObjectBuilder()
                            .add("id", user.getId())
                            .add("name", user.getName())
            );
        }

        JsonArray usersJson = jsonArrayBuilder.build();

        System.out.println(usersJson.toString());

        return usersJson;
    }
}
