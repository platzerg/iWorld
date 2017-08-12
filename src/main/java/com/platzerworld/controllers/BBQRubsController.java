package com.platzerworld.controllers;

import com.platzerworld.entities.dto.GewuerzDTO;
import com.platzerworld.entities.dto.RubDTO;
import com.platzerworld.service.BBQRubsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by platzerworld on 09.08.17.
 */
@Path("rubs")
public class BBQRubsController {


    @Inject
    private BBQRubsService rubsService;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RubDTO> getAllRubGewuerzMischungen() {
        List<RubDTO> allRubs = rubsService.getAllRubs();

        return allRubs;
    }

    @Path("/showbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RubDTO show(@PathParam("id") int id) {
        RubDTO rubDTO = this.rubsService.getRubById(id);

        return rubDTO;
    }

    @Path("/showbyname/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RubDTO> getRubsByName(@PathParam("name") String name) {
        List<RubDTO> allRubs = this.rubsService.getAllRubsByName(name);

        return allRubs;
    }

    @Path("/adds")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RubDTO> addRubs(final List<RubDTO> rubDTO) {
        List<RubDTO> newRubs = this.rubsService.addRubs(rubDTO);

        return newRubs;
    }

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RubDTO addRub(final RubDTO rubDTO) {
        RubDTO newRRubDTO = this.rubsService.addRub(rubDTO);

        return newRRubDTO;
    }

    @Path("/rub/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RubDTO addGewuerzToRub(@PathParam("id") int id, final GewuerzDTO gewuerzDTO) {
        RubDTO rubDTO = this.rubsService.addGewurzToRub(id, gewuerzDTO);
        return rubDTO;
    }

    @Path("/rub/{id}/gewuerze")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RubDTO addGewuerzeToRub(@PathParam("id") int id, final List<GewuerzDTO> gewuerze) {
        RubDTO rubDTO = this.rubsService.addGewurzeToRub(id, gewuerze);
        return rubDTO;
    }

    @Path("/rub/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RubDTO updateRub(final RubDTO rubDTO) {
        RubDTO updatedRubDTO = this.rubsService.updateRub(rubDTO);
        return updatedRubDTO;
    }

    @Path("/gpl")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RubDTO addRub() {
        RubDTO rub = new RubDTO();
        rub.setName("Mein Magic Dust rub");
        rub.setBeschreibung("Meine Rub Beschreibung");
        rub.setHerkunft("Klaus grillt");
        rub.setUrl("http://klaus-grillt.de");

        GewuerzDTO gewuerz = new GewuerzDTO();
        gewuerz.setBeschreibung("Gewürzbeschreibung");
        gewuerz.setName("Paprika");
        gewuerz.setUrl("https://www.ankerkraut.de/paprika-edelsuess");
        gewuerz.setMenge(100);
        gewuerz.setMengeneinheit("Gramm");

        rub.getGewuerze().add(gewuerz);

        RubDTO newRubDTO = this.rubsService.addRub(rub);

        return newRubDTO;
    }

    @Path("/deletebyid/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteById(@PathParam("id") int id) {
        this.rubsService.deleteRubById(id);
        return "@DELETE/delete/" +id +" OK";
    }

    @Path("/deletebyname/{name}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteByName(@PathParam("name") String name) {
        this.rubsService.deleteRubsByIdByname(name);
        return "@DELETE/delete/{name} OK";
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteRub(final RubDTO rubDTO) {

        return "@DELETE OK";
    }
}
