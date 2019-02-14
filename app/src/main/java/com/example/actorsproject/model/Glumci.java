package com.example.actorsproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Glumci {
    private int id;
    private String ime;
    private String prezime;
    private String bioGrafija;
    private String slika;
    private double ocena;
    private Date datumRodjenja;
    private Date datumSmrti;
    private List<Filmovi> filmovi = new ArrayList<>();

    public Glumci(){

    }

    public Glumci(int id, String ime, String prezime, String bioGrafija, String slika, double ocena, Date datumRodjenja, Date datumSmrti, List<Filmovi> filmovi) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.bioGrafija = bioGrafija;
        this.slika = slika;
        this.ocena = ocena;
        this.datumRodjenja = datumRodjenja;
        this.datumSmrti = datumSmrti;
        this.filmovi = filmovi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBioGrafija() {
        return bioGrafija;
    }

    public void setBioGrafija(String bioGrafija) {
        this.bioGrafija = bioGrafija;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumSmrti() {
        return datumSmrti;
    }

    public void setDatumSmrti(Date datumSmrti) {
        this.datumSmrti = datumSmrti;
    }

    public List<Filmovi> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<Filmovi> filmovi) {
        this.filmovi = filmovi;
    }

    public String toString(){
        String text;
        text =  ime + " " + prezime + "\n" + "BioGrafija glumca: " + bioGrafija + "\n" + "Ocena Glumca: " + ocena;
        return text;
    }
}
