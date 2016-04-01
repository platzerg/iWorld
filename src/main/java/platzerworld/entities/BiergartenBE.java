package platzerworld.entities;

import platzerworld.entities.listener.TraceListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "T_BG_Biergarten",schema = "platzerworld")
@EntityListeners(TraceListener.class)
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = BiergartenBE.FIND_ALL, query = "SELECT m FROM BiergartenBE m")
})
public class BiergartenBE {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "BiergartenBE.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String strasse;
    private String ort;
    private String plz;
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


    public BiergartenBE () {

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

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
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
}
