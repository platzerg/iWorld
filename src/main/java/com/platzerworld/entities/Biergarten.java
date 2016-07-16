package com.platzerworld.entities;

import com.platzerworld.entities.listener.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "T_BG_Biergarten",schema = "platzerworld")
@EntityListeners({
        TraceListener.class,
        CreatedAtListener.class,
        UpdatedAtListener.class
})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Biergarten.FIND_ALL, query = "SELECT m FROM Biergarten m"),
        @NamedQuery(name = "biergarten.list", query = "select u from Biergarten u")
})
public class Biergarten implements Creatable, Updatable{

    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Biergarten.findAll";

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String telefon;
    private String url;
    private String email;
    private String latitude;
    private String longitude;
    private String descShort;
    private String descLong;
    private String mass;
    private String apfelschorle;
    private String riesenbreze;
    private String obazda;
    private String biermarke;
    private String lieblingsgericht;
    private String speisekommentar;
    private Boolean favorit;

    private Adresse adresse;

    /*
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    */


    public Biergarten() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getApfelschorle() {
        return apfelschorle;
    }

    public void setApfelschorle(String apfelschorle) {
        this.apfelschorle = apfelschorle;
    }

    public String getRiesenbreze() {
        return riesenbreze;
    }

    public void setRiesenbreze(String riesenbreze) {
        this.riesenbreze = riesenbreze;
    }

    public String getObazda() {
        return obazda;
    }

    public void setObazda(String obazda) {
        this.obazda = obazda;
    }

    public String getBiermarke() {
        return biermarke;
    }

    public void setBiermarke(String biermarke) {
        this.biermarke = biermarke;
    }

    public String getLieblingsgericht() {
        return lieblingsgericht;
    }

    public void setLieblingsgericht(String lieblingsgericht) {
        this.lieblingsgericht = lieblingsgericht;
    }

    public String getSpeisekommentar() {
        return speisekommentar;
    }

    public void setSpeisekommentar(String speisekommentar) {
        this.speisekommentar = speisekommentar;
    }

    public Boolean getFavorit() {
        return favorit;
    }

    public void setFavorit(Boolean favorit) {
        this.favorit = favorit;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public void setCreatedAt(Date date) {
        System.out.println("setCreatedAt");
    }

    @Override
    public void setUpdatedAt(Date date) {
        System.out.println("setUpdatedAt");
    }

}
