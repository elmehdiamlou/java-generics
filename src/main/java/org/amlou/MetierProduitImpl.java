package org.amlou;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private static List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit produit) {
        produits.add(produit);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        return produits.stream().filter(p -> id == p.getId()).findAny().orElse(null);
    }

    @Override
    public void delete(long id) {
        produits.removeIf(p -> p.getId() == id);
    }

    @Override
    public void saveAll() throws IOException {
        File file = new File("produits.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.reset();
        objectOutputStream.writeObject(produits);
    }
}
