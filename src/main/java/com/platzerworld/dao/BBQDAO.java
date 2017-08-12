package com.platzerworld.dao;

import com.platzerworld.entities.Adresse;
import com.platzerworld.entities.Biergarten;
import com.platzerworld.entities.Gewuerz;
import com.platzerworld.entities.Rub;
import com.platzerworld.entities.dto.GewuerzDTO;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by platzerworld on 02.07.16.
 */
@Stateless
public class BBQDAO extends DAO {

    public Biergarten create(String name, String pwd, String mail) {
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
        return this.create(biergarten);
    }

    public Rub updateRub(Rub rub) {
        return this.update(rub);
    }

    public Rub updateRub(int id, List<Gewuerz> gewuerze) {
        Rub rub = this.find(Rub.class, id);
        if (rub == null) {
            throw new IllegalArgumentException("comment with id " + id + " not found");
        }

        for (Gewuerz gewuerz : gewuerze) {
            gewuerz.setRub(rub);
            this.update(gewuerz);

        }

        return this.find(Rub.class, id);
    }

    public Rub updateRub(int id, Gewuerz gewuerz) {
        Rub rub = this.find(Rub.class, id);
        if (rub == null) {
            throw new IllegalArgumentException("comment with id " + id + " not found");
        }

        gewuerz.setRub(rub);

        this.update(gewuerz);

        return this.find(Rub.class, id);
    }

    public void delete(int id) {
        this.delete(Biergarten.class, id);
    }

    public Biergarten getBiergartenById(int biergartenId) {
        Biergarten biergrten = this.find(Biergarten.class, biergartenId);
        if (biergrten == null) {
            throw new IllegalArgumentException("Biergarten with id " + biergartenId + " not found");
        }
        return biergrten;
    }

    public List<Biergarten> list(int first, int max) {
        return this.namedFind(Biergarten.class, "biergarten.list", first, max);
    }
}
