package org.amlou;

import java.io.Serializable;

public class Produit implements Serializable {
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nbrStock;

    public Produit(long id, String nom, String marque, double prix, String description, int nbrStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrStock=" + nbrStock +
                "}\n";
    }
}
