package com.platzerworld.controllers;

import com.platzerworld.entities.Biergarten;
import com.platzerworld.service.BiergartenService;

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
@Path("biergarten")
public class BiergartenController {

    @Inject
    private BiergartenService biergartenService;

    @Path("all")
    @GET
    @Produces("application/json")
    public JsonArray getAllUsers() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        List<Biergarten> restult = biergartenService.getAllBiergarten();

        for(Biergarten biergarten : restult) {
            jsonArrayBuilder.add(
                    Json.createObjectBuilder()
                            .add("id", biergarten.getId())
                            .add("name", biergarten.getName() != null ? biergarten.getName() : "")
                            .add("strasse", biergarten.getAdresse().getStrasse() != null ? biergarten.getAdresse().getStrasse() : "")
                            .add("plz", biergarten.getAdresse().getPlz() != null ? biergarten.getAdresse().getPlz() : "")
                            .add("ort", biergarten.getAdresse().getOrt() != null ? biergarten.getAdresse().getOrt() : "")
                            .add("telefon", biergarten.getTelefon() != null ? biergarten.getTelefon() : "")
                            .add("url", biergarten.getUrl() != null ? biergarten.getUrl() : "")
                            .add("email", biergarten.getEmail() != null ? biergarten.getEmail() : "")
                            .add("latitude", biergarten.getLatitude() != null ? biergarten.getLatitude() : "")
                            .add("longitude", biergarten.getLongitude() != null ? biergarten.getLongitude() : "")
                            .add("descShort", biergarten.getDescShort() != null ? biergarten.getDescShort() : "")
                            .add("descLong", biergarten.getDescLong() != null ? biergarten.getDescLong() : "")
                            .add("mass", biergarten.getMass() != null ? biergarten.getMass() : "")
                            .add("apfelschorle", biergarten.getApfelschorle() != null ? biergarten.getApfelschorle() : "")
                            .add("riesenbreze", biergarten.getRiesenbreze() != null ? biergarten.getRiesenbreze() : "")
                            .add("obazda", biergarten.getObazda() != null ? biergarten.getObazda() : "")
                            .add("biermarke", biergarten.getBiermarke() != null ? biergarten.getBiermarke() : "")
                            .add("lieblingsgericht", biergarten.getLieblingsgericht() != null ? biergarten.getLieblingsgericht() : "")
                            .add("speisekommentar", biergarten.getSpeisekommentar() != null ? biergarten.getSpeisekommentar() : "")
                            .add("favorit", biergarten.getFavorit() != null ? biergarten.getFavorit() : false)
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
