package com.platzerworld.service;


import com.platzerworld.dao.BBQDAO;
import com.platzerworld.entities.Biergarten;
import com.platzerworld.entities.Gewuerz;
import com.platzerworld.entities.Rub;
import com.platzerworld.entities.dto.GewuerzDTO;
import com.platzerworld.entities.dto.RubDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BBQRubsService {
    @EJB
    private BBQDAO bbqDAO;

    @PersistenceContext(unitName = "iWorld")
    private EntityManager entityManager;

    public List<RubDTO> getAllRubs() {
        List<RubDTO> allRubDTO = new ArrayList<>();
        entityManager.flush();

        List<Rub> allRubs = entityManager.createNamedQuery(Rub.FIND_ALL, Rub.class).getResultList();

        for (Rub rub : allRubs) {
            allRubDTO.add(this.convertToRubDTO(rub));
        }

        return allRubDTO;
    }

    public RubDTO getRubById(int id) {
        Rub rub = bbqDAO.find(Rub.class, id);

        return this.convertToRubDTO(rub);
    }

    public List<Biergarten> getBiergartenByName(String name) {
        return bbqDAO.getBiergartenByName(name);
    }

    public List<RubDTO> getAllRubsByName(String name) {
        List<RubDTO> allRubsDTO = new ArrayList<>();

        List<Rub> allRubGewuerzMischungenByname = bbqDAO.loadRubsByName(name);
        for (Rub rub : allRubGewuerzMischungenByname) {
            allRubsDTO.add(this.convertToRubDTO(rub));
        }


        return allRubsDTO;
    }

    public void deleteRubsByIdByname(String name) {

        List<Rub> rubList = bbqDAO.getRubByName(name);
        for (Rub rub : rubList) {
            bbqDAO.delete(rub.getId());
        }
    }

    public void deleteRubById(int id) {
        bbqDAO.delete(id);
    }

    public RubDTO addGewurzeToRub(int rubId, List<GewuerzDTO> gewuerze) {
        List<Gewuerz> gewuerzList = new ArrayList<>();
        for (GewuerzDTO gewuerzDTO : gewuerze) {
            Gewuerz gewuerz = this.convertToGewuerz(gewuerzDTO);
            gewuerzList.add(gewuerz);
        }

        Rub updatedRub = bbqDAO.updateRub(rubId, gewuerzList);

        RubDTO newRubDTO = this.convertToRubDTO(updatedRub);

        return newRubDTO;
    }

    public RubDTO addGewurzToRub(int rubId, GewuerzDTO gewuerzDTO) {
        RubDTO rub = this.getRubById(rubId);

        Gewuerz newGewuerz = this.convertToGewuerz(gewuerzDTO);

        Rub updatedRub = bbqDAO.updateRub(rubId, newGewuerz);

        RubDTO newRubDTO = this.convertToRubDTO(updatedRub);

        return newRubDTO;
    }

    public RubDTO updateRub(RubDTO rubDTO) {
        Rub updatedRub = this.convertToRub(rubDTO);

        Rub rub = bbqDAO.updateRub(updatedRub);

        RubDTO newRubDTO = this.convertToRubDTO(rub);

        return newRubDTO;
    }


    public List<RubDTO> addRubs(final List<RubDTO> rubsDTO) {
        List<RubDTO> newRubs= new ArrayList<>();

        for (RubDTO rubDTO : rubsDTO) {
            RubDTO newRubDTO = this.addRub(rubDTO);
            newRubs.add(newRubDTO);
        }

        return newRubs;
    }


    public RubDTO addRub(final RubDTO rubDTO) {
        Rub newRub = this.convertToRub(rubDTO);
        Rub rub = bbqDAO.create(newRub);
        RubDTO newRubDTO = this.convertToRubDTO(rub);
        return newRubDTO;
    }

    private RubDTO convertToRubDTO(Rub rub) {
        RubDTO rubDTO = new RubDTO();

        rubDTO.setId(rub.getId());
        rubDTO.setCreatedUser(rub.getCreatedUser());
        rubDTO.setCreationDate(rub.getCreationDate());
        rubDTO.setModificationUser(rub.getModificationUser());
        rubDTO.setModificationDate(rub.getModificationDate());
        rubDTO.setLockVersion(rub.getLockVersion());

        rubDTO.setName(rub.getName());
        rubDTO.setBeschreibung(rub.getBeschreibung());
        rubDTO.setHerkunft(rub.getHerkunft());
        rubDTO.setUrl(rub.getUrl());



        for (Gewuerz gewuerz : rub.getGewuerze()) {
            GewuerzDTO gewuerzDTO = new GewuerzDTO();
            gewuerzDTO.setId(gewuerz.getId());
            gewuerzDTO.setCreatedUser(gewuerz.getCreatedUser());
            gewuerzDTO.setCreationDate(gewuerz.getCreationDate());
            gewuerzDTO.setModificationUser(gewuerz.getModificationUser());
            gewuerzDTO.setModificationDate(gewuerz.getModificationDate());
            gewuerzDTO.setLockVersion(gewuerz.getLockVersion());

            gewuerzDTO.setName(gewuerz.getName());
            gewuerzDTO.setArt(gewuerz.getArt());
            gewuerzDTO.setBeschreibung(gewuerz.getBeschreibung());
            gewuerzDTO.setMenge(gewuerz.getMenge());
            gewuerzDTO.setMengeneinheit(gewuerz.getMengeneinheit());
            gewuerzDTO.setUrl(gewuerz.getUrl());

            gewuerzDTO.setRub(rubDTO);


            rubDTO.getGewuerze().add(gewuerzDTO);
        }

        return rubDTO;
    }

    private Rub convertToRub(RubDTO rubDTO) {
        Rub rub = new Rub();

        rub.setId(rubDTO.getId());
        rub.setCreatedUser(rubDTO.getCreatedUser());
        rub.setCreationDate(rubDTO.getCreationDate());
        rub.setModificationUser(rubDTO.getModificationUser());
        rub.setModificationDate(rubDTO.getModificationDate());
        rub.setLockVersion(rubDTO.getLockVersion());

        rub.setName(rubDTO.getName());
        rub.setBeschreibung(rubDTO.getBeschreibung());
        rub.setHerkunft(rubDTO.getHerkunft());
        rub.setUrl(rubDTO.getUrl());

        for (GewuerzDTO gewuerzDTO : rubDTO.getGewuerze()) {
            Gewuerz gewuerz = new Gewuerz();
            gewuerz.setId(gewuerzDTO.getId());
            gewuerz.setCreatedUser(gewuerzDTO.getCreatedUser());
            gewuerz.setCreationDate(gewuerzDTO.getCreationDate());
            gewuerz.setModificationUser(gewuerzDTO.getModificationUser());
            gewuerz.setModificationDate(gewuerzDTO.getModificationDate());
            gewuerz.setLockVersion(gewuerzDTO.getLockVersion());

            gewuerz.setName(gewuerzDTO.getName());
            gewuerz.setArt(gewuerzDTO.getArt());
            gewuerz.setBeschreibung(gewuerzDTO.getBeschreibung());
            gewuerz.setMenge(gewuerzDTO.getMenge());
            gewuerz.setMengeneinheit(gewuerzDTO.getMengeneinheit());
            gewuerz.setUrl(gewuerzDTO.getUrl());


            rub.getGewuerze().add(gewuerz);
            gewuerz.setRub(rub);
        }

        return rub;
    }

    private Gewuerz convertToGewuerz(GewuerzDTO gewuerzDTO) {
        Gewuerz gewuerz = new Gewuerz();
        gewuerz.setId(gewuerzDTO.getId());
        gewuerz.setCreatedUser(gewuerzDTO.getCreatedUser());
        gewuerz.setCreationDate(gewuerzDTO.getCreationDate());
        gewuerz.setModificationUser(gewuerzDTO.getModificationUser());
        gewuerz.setModificationDate(gewuerzDTO.getModificationDate());
        gewuerz.setLockVersion(gewuerzDTO.getLockVersion());

        gewuerz.setName(gewuerzDTO.getName());
        gewuerz.setArt(gewuerzDTO.getArt());
        gewuerz.setBeschreibung(gewuerzDTO.getBeschreibung());
        gewuerz.setMenge(gewuerzDTO.getMenge());
        gewuerz.setMengeneinheit(gewuerzDTO.getMengeneinheit());
        gewuerz.setUrl(gewuerzDTO.getUrl());

        return gewuerz;
    }
}
