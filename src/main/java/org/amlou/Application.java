package org.amlou;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.printf("\n---------------------------------------------\n" +
                    "1. Afficher la liste des produits.\n" +
                    "2. Rechercher un produit par son id.\n" +
                    "3. Ajouter un nouveau produit dans la liste.\n" +
                    "4. Supprimer un produit par id.\n" +
                    "5. Quitter ce programme.\n" +
                    "---------------------------------------------\n\n");
            try {
                final IMetier<Produit> metier = new MetierProduitImpl();
                Scanner input = new Scanner(System.in);
                int selectedIndex;

                System.out.println("Veuillez saisir votre choix : ");
                selectedIndex = input.nextInt();
                System.out.printf("\n");

                switch (selectedIndex) {
                    case 1:
                        List<Produit> list = metier.getAll();
                        if (list.isEmpty())
                            System.out.println("Aucun produit trouvé");
                        else {
                            for (Produit p : metier.getAll())
                                System.out.print(p);
                        }

                        break;
                    case 2:
                        System.out.printf("Veuillez saisir l'identifiant : ");
                        Produit produitTrouve = metier.findById(input.nextLong());
                        if (produitTrouve != null)
                            System.out.println(produitTrouve);
                        else
                            System.out.println("Aucun produit n'existe avec l'identifiant donné.");
                        break;
                    case 3:
                        Field[] fields = Produit.class.getDeclaredFields();
                        List values = new ArrayList<>();
                        for (Field field : fields) {
                            System.out.printf("%s : ", field.getName());
                            values.add(input.next());
                        }
                        Produit produit = new Produit(Long.valueOf((String) values.get(0)), (String) values.get(1), (String) values.get(2), Double.valueOf((String) values.get(3)), (String) values.get(4), Integer.valueOf((String) values.get(5)));
                        metier.add(produit);
                        System.out.println("Produit ajouté avec succès");
                        break;
                    case 4:
                        System.out.printf("Veuillez saisir l'identifiant : ");
                        Produit produitSupprimer = metier.findById(input.nextLong());
                        if (produitSupprimer != null) {
                            metier.delete(produitSupprimer.getId());
                            System.out.println("Produit supprimé avec succès");
                        } else
                            System.out.println("Aucun produit n'existe avec l'identifiant donné.");
                        break;
                    case 5:
                        System.out.println("Quitter le programme");
                        System.exit(0);
                        break;

                }
            } catch (Exception e) {
                System.out.printf("Une erreur s'est produite veuillez réessayer.\n%s\n", e);
                System.exit(0);
            }
        }
    }
}