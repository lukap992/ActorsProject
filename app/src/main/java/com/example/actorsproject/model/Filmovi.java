package com.example.actorsproject.model;

public class Filmovi {

    private int id;
    private String imeFilma;
    private double ocenaFilma;
    private String glavniGlumac;

    public Filmovi(int id, String imeFilma, double ocenaFilma, String glavniGlumac) {
        this.id = id;
        this.imeFilma = imeFilma;
        this.ocenaFilma = ocenaFilma;
        this.glavniGlumac = glavniGlumac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImeFilma() {
        return imeFilma;
    }

    public void setImeFilma(String imeFilma) {
        this.imeFilma = imeFilma;
    }

    public double getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(double ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    public String getGlavniGlumac() {
        return glavniGlumac;
    }

    public void setGlavniGlumac(String glavniGlumac) {
        this.glavniGlumac = glavniGlumac;
    }
    @Override
    public String toString() {
        String text;
        text =  imeFilma + "\n" + "Ocena filma: " + ocenaFilma;
        return text;
    }

    public String toString1() {
        String text;
        text =  imeFilma + "\n" + "Ocena filma: " + ocenaFilma + "\n" + "Glavni Glumac: " + glavniGlumac;
        return text;
    }
}
