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
                            .add("name", biergartenBE.getName() != null ? biergartenBE.getName() : "")
                            .add("strasse", biergartenBE.getStrasse() != null ? biergartenBE.getStrasse() : "")
                            .add("plz", biergartenBE.getPlz() != null ? biergartenBE.getPlz() : "")
                            .add("ort", biergartenBE.getOrt() != null ? biergartenBE.getOrt() : "")
                            .add("telefon", biergartenBE.getTelefon() != null ? biergartenBE.getTelefon() : "")
                            .add("url", biergartenBE.getUrl() != null ? biergartenBE.getUrl() : "")
                            .add("email", biergartenBE.getEmail() != null ? biergartenBE.getEmail() : "")
                            .add("latitude", biergartenBE.getLatitude() != null ? biergartenBE.getLatitude() : "")
                            .add("longitude", biergartenBE.getLongitude() != null ? biergartenBE.getLongitude() : "")
                            .add("descShort", biergartenBE.getDescShort() != null ? biergartenBE.getDescShort() : "")
                            .add("descLong", biergartenBE.getDescLong() != null ? biergartenBE.getDescLong() : "")
                            .add("mass", biergartenBE.getMass() != null ? biergartenBE.getMass() : "")
                            .add("apfelschorle", biergartenBE.getApfelschorle() != null ? biergartenBE.getApfelschorle() : "")
                            .add("riesenbreze", biergartenBE.getRiesenbreze() != null ? biergartenBE.getRiesenbreze() : "")
                            .add("obazda", biergartenBE.getObazda() != null ? biergartenBE.getObazda() : "")
                            .add("biermarke", biergartenBE.getBiermarke() != null ? biergartenBE.getBiermarke() : "")
                            .add("lieblingsgericht", biergartenBE.getLieblingsgericht() != null ? biergartenBE.getLieblingsgericht() : "")
                            .add("speisekommentar", biergartenBE.getSpeisekommentar() != null ? biergartenBE.getSpeisekommentar() : "")
                            .add("favorit", biergartenBE.getFavorit() != null ? biergartenBE.getFavorit() : false)
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
