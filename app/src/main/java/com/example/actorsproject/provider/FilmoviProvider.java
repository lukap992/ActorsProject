package com.example.actorsproject.provider;

import com.example.actorsproject.model.Filmovi;

import java.util.ArrayList;
import java.util.List;

public class FilmoviProvider {

    public static List<Filmovi> getFilmovi(){
        List<Filmovi> listaFilmova = new ArrayList<>();

        listaFilmova.add(new Filmovi(0, "Batman Begins", 9.0, "Christian Bale"));
        listaFilmova.add(new Filmovi(1,"The Dark Knight", 10.0, "Christian Bale"));
        listaFilmova.add(new Filmovi(2, "The Dark Knight Rises", 9.5, "Christian Bale"));
        listaFilmova.add(new Filmovi(3,"RobinHud 2010", 8.0,"Robin Hud"));
        listaFilmova.add(new Filmovi(4,"RobinHud 2018",9.9,"Robin Hud"));
        listaFilmova.add(new Filmovi(5,"DeadPool 1",9.1,"Rajan Rejnolds"));
        listaFilmova.add(new Filmovi(6,"DeadPool 2",10.0,"Rajan Rejnolds"));

        return listaFilmova;
    }
     public static List<String> getFilmoviNames(){
        List<String> imenaFilmova = new ArrayList<>();
        for(Filmovi f: getFilmovi()){
            imenaFilmova.add(f.getImeFilma());
        }
        return imenaFilmova;
     }
     public static List<String> getFilmoviToString1(){
        List<String> filmovi = new ArrayList<>();
        for(Filmovi f: getFilmovi()){
            filmovi.add(f.toString1());
        }
        return filmovi;
     }
}
