package managers;

import java.util.ArrayList;

import entities.Type;

/**
 * Created by mayammouarangue on 04/12/17.
 */

public class ManagerType {
    private static ArrayList<Type> lesTypes;

    private static void init(){
        lesTypes = new ArrayList<>();

        lesTypes.add(new Type(1,"Administration"));
        lesTypes.add(new Type(2,"Corporate"));
        lesTypes.add(new Type(3,"Franchise"));
        lesTypes.add(new Type(4,"Professionnel"));
    }

    public static ArrayList<Type> getAll(){
        if (lesTypes == null){
            init();
        }
        return lesTypes;
    }
}
