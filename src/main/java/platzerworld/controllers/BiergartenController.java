package platzerworld.controllers;

import platzerworld.entities.BiergartenBE;
import platzerworld.entities.Movie;
import platzerworld.entities.RatingService;
import platzerworld.service.BiergartenService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by platzerworld on 26.03.16.
 */
@Path("biergarten")
public class BiergartenController {

    @Inject
    private BiergartenService biergartenService;

    @Path("all")
    @GET
    @Produces("application/json")
    public JsonArray getAllUsers() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        List<BiergartenBE> restult = biergartenService.getAllBiergarten();

        for(BiergartenBE biergartenBE: restult) {
            jsonArrayBuilder.add(
                    Json.createObjectBuilder()
                            .add("id", biergartenBE.getId())
                            .add("name", biergartenBE.getName())
                            .add("plz", biergartenBE.getPlz())
                            .add("ort", biergartenBE.getOrt())
                            .add("telefon", biergartenBE.getTelefon())
                            .add("url", biergartenBE.getUrl())
                            .add("email", biergartenBE.getEmail())
                            .add("latitude", biergartenBE.getLatitude())
                            .add("longitude", biergartenBE.getLongitude())
            );
        }

        JsonArray usersJson = jsonArrayBuilder.build();

        System.out.println(usersJson.toString());

        return usersJson;
    }

    @Path("add")
    @GET
    @Produces("application/json")
    public JsonArray addBiergarten() {
        this.biergartenService.addBiergarten();

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        return jsonArrayBuilder.build();
    }
}
