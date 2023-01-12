package ihm;

import fraction.Fraction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ecran {
    /**
     * Message "titre de l'application"
     */
    private String[] TITRE = new String[]{
            "==============================",
            " -- Les nombres rationnels -- ",
            "==============================",
    };
    /**
     * Message "menu de l'application"
     */
    private String[] MENU = new String[]{
            " ",
            "-- 1 : Créer une fraction :     ~~ saisir numérateur puis dénominateur ~~",
            "-- 2 : Créer une fraction :     ~~ saisir un entier                    ~~",
            "-- 0 : Quitter l'application :  ~~ vous allez quitter l'application    ~~",
            " "
    };
    private Boolean isAffiche = true;
    private Integer saisieUtilisateur;

    public Ecran() {
        initialiser();
        while (isAffiche){
            if (saisieUtilisateur >= 3 || saisieUtilisateur < 0){
                System.out.println("Erreur de saisie");
                isAffiche = false;
            }
            else {
                switch (saisieUtilisateur){
                    case 1:
                        System.out.println("Lancement de la création d'une fraction saisie du Numérateur et Dénominateur");
                        saisirNumerateurDenominateur();
                        break;
                    case 2:
                        System.out.println("C'est Ok aussi");
                        break;
                }
            }
            isAffiche = false;

        }

    }

    private void afficher(String[] tableau){
        for (String ligne: tableau
             ) {
            System.out.println(ligne);
        }
    }

    private void scanner(){
        System.out.println(" ");
        System.out.println(" -> Veuillez saisir un chiffre du menu : ");
        try{
            Scanner scan = new Scanner(System.in);
            this.saisieUtilisateur = scan.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Saisie invalide");
            isAffiche = false;
        }
    }

    private void initialiser(){
        afficher(this.TITRE);
        afficher(this.MENU);
        scanner();
    }

    private void saisirNumerateurDenominateur(){
        int numerateur = 0;
        int denominateur = 1;
        System.out.println(" ");
        System.out.println(" -> Veuillez saisir un numérateur : ");
        try{
            Scanner scan = new Scanner(System.in);
            numerateur = scan.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Saisie invalide");
            isAffiche = false;
        }
        System.out.println(" ");
        System.out.println(" -> Veuillez saisir un dénominateur : ");
        try{
            Scanner scan = new Scanner(System.in);
            denominateur = scan.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Saisie invalide");
            isAffiche = false;
        }
        Fraction fraction = new Fraction(numerateur, denominateur);
        System.out.println(fraction.toString());

    }
}
