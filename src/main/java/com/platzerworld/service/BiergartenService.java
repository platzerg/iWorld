package com.platzerworld.service;


import com.platzerworld.dao.BiergartenDAO;
import com.platzerworld.entities.Adresse;
import com.platzerworld.entities.Biergarten;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Stateless
public class BiergartenService {
    @EJB
    private BiergartenDAO biergartenDAO;

    @PersistenceContext(unitName = "iWorld")
    private EntityManager entityManager;

    public List<Biergarten> getAllBiergarten() {
        entityManager.flush();
        return entityManager.createNamedQuery(Biergarten.FIND_ALL, Biergarten.class).getResultList();
    }

    public Biergarten getAllBiergartenById(int id) {
        return biergartenDAO.find(Biergarten.class, id);
    }

    public List<Biergarten> getBiergartenByName(String name) {
        return biergartenDAO.getBiergartenByName(name);
    }

    public void deleteBiergartenByname(String name) {
        List<Biergarten> biergartenList = biergartenDAO.getBiergartenByName(name);
        biergartenDAO.getBiergartenById(2);
    }

    public void deleteBiergartenById(int id) {
        biergartenDAO.delete(id);
    }

    public Biergarten addBiergarten() {
        Biergarten biergarten = new Biergarten();

        biergarten.setName("platzerworld");
        Adresse adresse = new Adresse();
        adresse.setStrasse("Gyßlingstraße");
        adresse.setPlz("80805");
        adresse.setOrt("München");
        biergarten.setAdresse(adresse);

        biergarten.setTelefon("089 / 36100880");//
        biergarten.setEmail("aumeister@aumeister.de");
        biergarten.setUrl("minihofbraeuhaus.de/");//
        biergarten.setLatitude("48,167011");
        biergarten.setLongitude("11,607648");
        biergarten.setMass("Mass");
        biergarten.setApfelschorle("AS");
        biergarten.setRiesenbreze("RB");
        biergarten.setObazda("Obazda");
        biergarten.setBiermarke("BM");
        biergarten.setLieblingsgericht("LG");
        biergarten.setSpeisekommentar("Speisekommentar");
        biergarten.setDescShort("DESC LONG");
        biergarten.setDescLong("Übers ganze Jahr süddeutsche Kost und Biere im gemütlichen und hundefreundlichen Gastgarten oder im Zelt.");
        biergarten.setFavorit(false);//
        Biergarten newBiergarten = biergartenDAO.create(biergarten);
        return newBiergarten;
    }
}
