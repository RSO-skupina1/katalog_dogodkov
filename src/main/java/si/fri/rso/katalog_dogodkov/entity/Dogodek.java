package si.fri.rso.katalog_dogodkov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="dogodki")
@NamedQuery(name = "Dogodek.findAll", query = "SELECT d FROM Dogodek d")
public class Dogodek implements Serializable {

    @Id
    private int id;

    @Column(name="naziv_dogodka")
    private String nazivDogodka;

    // Datum mora biti podan v miliskeundah.
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datum_dogodka")
    private Date datumDogodka;

    @Column(name="opis_dogodka")
    private String opisDogodka;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivDogodka() {
        return nazivDogodka;
    }

    public void setNazivDogodka(String nazivDogodka) {
        this.nazivDogodka = nazivDogodka;
    }

    public Date getDatumDogodka() {
        return datumDogodka;
    }

    public void setDatumDogodka(Date datumDogodka) {
        this.datumDogodka = datumDogodka;
    }

    public String getOpisDogodka() {
        return opisDogodka;
    }

    public void setOpisDogodka(String opisDogodka) {
        this.opisDogodka = opisDogodka;
    }

    @Override
    public String toString() {
        return ("id: " + this.id + ", " +
                "naziv dogodka: '" + this.nazivDogodka +
                "', datum dogodka: " + this.datumDogodka.toString() +
                ", opis dogodka: '" + this.opisDogodka + "'");
    }
}
