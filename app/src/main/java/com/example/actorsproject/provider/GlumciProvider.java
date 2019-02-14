package com.example.actorsproject.provider;

import com.example.actorsproject.model.Filmovi;
import com.example.actorsproject.model.Glumci;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlumciProvider {

    public static List<Filmovi> filmoviKristijanaBejla(){
        List<Filmovi> listaKristijan = new ArrayList<>();

        listaKristijan.add(new Filmovi(0, "Batman Begins", 9.0, "Christian Bale"));
        listaKristijan.add(new Filmovi(1,"The Dark Knight", 10.0, "Christian Bale"));
        listaKristijan.add(new Filmovi(2, "The Dark Knight Rises", 9.5,"Christian Bale"));
        return listaKristijan;
    }

    public static List<Filmovi> filmoviRobinHud() {
        List<Filmovi> listaRobinHud = new ArrayList<>();

        listaRobinHud.add(new Filmovi(1, "RobinHud 2010", 8.0, "Robin Hud"));
        listaRobinHud.add(new Filmovi(2, "RobinHud 2018", 9.9, "Robin Hud"));


        return listaRobinHud;
    }

    public static List<Filmovi> filmoviRajanRejnolds() {

        List<Filmovi> listaDeadPool = new ArrayList<>();
        listaDeadPool.add(new Filmovi(0, "DeadPool 1", 9.1, "Rajan Rejnolds"));
        listaDeadPool.add(new Filmovi(1, "DeadPool 2", 10.0, "Rajan Rejnolds"));

        return listaDeadPool;
    }

    // podesiti u filmovi da prima listu.

    public static List<Glumci> getGlumci(){

        List<Glumci> listaGlumaca = new ArrayList<>();
        listaGlumaca.add(new Glumci(0, "Christian", "Bale", "Poznati Betmen koji spasava Gotham City", "batman.jpg", 9.0, new Date(), new Date(),filmoviKristijanaBejla()));
        listaGlumaca.add(new Glumci(1, "Rajan","Rejnolds","Takođe poznat kao \"Brbljivi plaćenik,\" Dedpul je poznat po svojoj pričljivoj prirodi i sklonosti da \"razbije četvrti zid\" , koji je koriščen od strane pisaca radi humorističkog efekta.","deadpool.jpg",7.7,new Date(),new Date(), filmoviRajanRejnolds()));
        listaGlumaca.add(new Glumci(2,"Robin","Hud","Robin Hud od svojih neprijatelja uzima novac i daje ga sirotinji ili ga vraća ukoliko im je prethodno pod nekim izgovorom uzet.","robinHud.jpg",8.9,new Date(),new Date(),filmoviRobinHud()));

        return listaGlumaca;
    }

    public static List<String> getGlumciNames(){
        List<String> glumci = new ArrayList<>();
        for(Glumci g: getGlumci()){
            glumci.add(g.getIme() + " " + g.getPrezime());
        }
        return glumci;
    }
    public static Glumci getGlumciByName(String ime){
        for(Glumci g: getGlumci()){
            if(g.getIme().equalsIgnoreCase(ime)){
                return g;
            }
        }
        return null;
    }
    public static List<String> getGlumciById(int id){
        List<String> listaGlumaca = new ArrayList<>();
        for(Glumci g: getGlumci()){
            if(g.getId() == id){
                listaGlumaca.add(g.getIme() + " " + g.getPrezime());
            }
        }
        return listaGlumaca;
    }
    public static List<Filmovi> getFilmGlumacById(int id){

        for (Glumci g: getGlumci()){
            if(g.getId() == id){
                return g.getFilmovi();
            }
        }
        return null;
    }
    public static Glumci getCeoGlumacById(int id){
        for(Glumci g: getGlumci()){
            if(g.getId() == id){
                return g;
            }
        }
        return null;
    }
}
