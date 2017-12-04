package managers;

import java.util.ArrayList;

import entities.Etablissement;

/**
 * Created by mayammouarangue on 04/12/17.
 */

public class ManagerEtablissement {
    private static ArrayList<Etablissement> lesEtabs;

    private static void init(){
        lesEtabs = new ArrayList<>();
        lesEtabs.add( new Etablissement(1,"Siege Social",1));
        lesEtabs.add( new Etablissement(2,"Saint-Denis",2));
        lesEtabs.add( new Etablissement(3,"Angus",2));
        lesEtabs.add( new Etablissement(4,"Fleury",2));
        lesEtabs.add( new Etablissement(5,"Notre-Dame",2));
        lesEtabs.add( new Etablissement(6,"Île-des-Soeurs",2));
        lesEtabs.add( new Etablissement(7,"Van Horne",2));
        lesEtabs.add( new Etablissement(8,"franchise",3));
        lesEtabs.add( new Etablissement(9,"Restaurant",4));

    }

    public static ArrayList<Etablissement> getAll(){
        if (lesEtabs == null){
            init();
        }
        return lesEtabs;
    }

}
