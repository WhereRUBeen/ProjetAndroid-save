package entities;

import java.io.Serializable;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Utilisateur implements Serializable{
    
    // attributs
    private int id;
    private String nom;
    private String prenom;

    private int etablissement_id;
    private Etablissement etablissement;
    private Type_Etablissement typeEtablissement;
    private Role role;
    private String userName;
    private String password;
    private boolean isVisible;
    private String tokenIdentification;
    private String tokenInscription;


//private int role_id;

    // contructeurs


    public Utilisateur(int id, String nom, String prenom, Etablissement etablissement, Role role, String userName, String password, boolean isVisible, String tokenIdentification, String tokenInscription) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.etablissement = etablissement;
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.isVisible = isVisible;
        this.tokenIdentification = tokenIdentification;
        this.tokenInscription = tokenInscription;
    }

    public Utilisateur(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public Utilisateur(String tokenIdentification){
        this.tokenIdentification = tokenIdentification;
    }

    // pour le sharedPreference
    public Utilisateur(int id, String nom, String prenom, String userName, String tokenIdentification) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.userName = userName;
        this.tokenIdentification = tokenIdentification;
    }

    //getters and setters


    public Type_Etablissement getTypeEtablissement() {
        return typeEtablissement;
    }

    public void setTypeEtablissement(Type_Etablissement typeEtablissement) {
        this.typeEtablissement = typeEtablissement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getTokenIdentification() {
        return tokenIdentification;
    }

    public void setTokenIdentification(String tokenIdentification) {
        this.tokenIdentification = tokenIdentification;
    }

    public String getTokenInscription() {
        return tokenInscription;
    }

    public void setTokenInscription(String tokenInscription) {
        this.tokenInscription = tokenInscription;
    }
    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
