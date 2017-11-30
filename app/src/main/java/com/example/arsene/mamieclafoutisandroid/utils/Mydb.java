package com.example.arsene.mamieclafoutisandroid.utils;

/**
     * Created by bigg- on 11/27/2017.
     */

    public class Mydb {
        public static final String madb = "mamie";

        public static class Etablissement{
            public static final String tablename = "Etablissement";
            public static final String id = "id";
            public static final String name = "name";
            public static final String tel = "tel";
            public static final String typeEtablissement = "typeetablissement";
            public static final String adresse = "adresse";
        }
        public static class Ingredient{
            public static final String tablename = "Ingredient";
            public static final String id = "id";
            public static final String denomination = "denomination";
            public static final String quantite = "quantite";
            public static final String unite_ingredient = "uniteingredient";
        }
        public static class Produit{
            public static final String tablename = "Produit";
            public static final String id = "id";
            public static final String nom = "nom";
            public static final String categorieid = "categorieid";
            public static final String categoriedenom = "categoriedenom";
            public static final String description = "description";
            public static final String prix = "prix";
            public static final String reference = "reference";
            public static final String poid = "poid";
            public static final String unite_id = "unite_id";
            public static final String estvisible = "estvisible";
        }
        public static class Utilisateur{
            public static final String tablename = "Utilisateur";
            public static final String id = "id";
            public static final String nom = "nom";
            public static final String prenom = "prenom";
            //  public static final String etablissement_id;
            public static final String etablissement = "etablissement";
            public static final String role = "role";
            public static final String userName = "username";
            public static final String password = "password";
            public static final String tokenIdentification = "tokenidentification";
            public static final String tokenInscription = "tokeninscription";

        }

        public static final class Role {
            public static final String nomTable = "role";
            public static final String id = "id";
            public static final String denomination = "denomination";
        }

    }

