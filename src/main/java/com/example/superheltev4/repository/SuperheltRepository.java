package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhelt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheltRepository {
    private List<Superhelt> superhelte = new ArrayList<>();

    public void createTestData () {
        Superhelt superhelt1 = new Superhelt("Hans","Flot",false, 2000,2.5);
        Superhelt superhelt2 = new Superhelt("Bob","Svæve",true, 1970,3.0);
        Superhelt superhelt3 = new Superhelt("Bob","Irriterende",true, 2002,1.0);
        Superhelt superhelt4 = new Superhelt("Bob","Random",true, 2010,5.0);
        Superhelt superhelt5 = new Superhelt("Torben","Creepy",false, 1862,1.5);
        superhelte.add(superhelt1);
        superhelte.add(superhelt2);
        superhelte.add(superhelt3);
        superhelte.add(superhelt4);
        superhelte.add(superhelt5);


    }

    public Superhelt createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {
        Superhelt hero = new Superhelt(name, superpower, human, introYear, strengthPoint);
        superhelte.add(hero);
        return hero;
    }

    public ArrayList<Superhelt> searchSuperhero(String searchTerm) {

        ArrayList<Superhelt> searchResult = new ArrayList<>();

        for (Superhelt helt : superhelte) {
            if (helt.getName().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                searchResult.add(helt);
            }
        }
        return searchResult;
    }

    public List<Superhelt> deleteSuperhero(String navn) {
        List<Superhelt> søgeResultater;
        søgeResultater=searchSuperhelt(navn);

        for(Superhelt helt : søgeResultater) {
            getSuperhelte().remove(helt);
        }
        return søgeResultater;
    }

    public void addAll(ArrayList<Superhelt> superheroes) {
        superheroes.addAll(superheroes);
    }

    public ArrayList<Superhelt> getSuperhelte() {
        return (ArrayList<Superhelt>) superhelte;
    }

    public ArrayList<Superhelt> searchSuperhelt(String searchTerm) {
        ArrayList<Superhelt> searchResult = new ArrayList<>();
        for (Superhelt helt : superhelte) {
            if (helt.getName().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                searchResult.add(helt);
            }
        }
        return searchResult;
    }
}
