package entities;

/**
 * Created by mayammouarangue on 27/11/17.
 */

public class Unite {
    int id;
    String denomination;

    // Constructeur Unite


    public Unite(int id, String denomination) {
        this.id = id;
        this.denomination = denomination;
    }
    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }
}
