package boundary;

import java.util.List;
import java.util.Scanner;
import noyauFonctionnel.controller.ControlChoisirNomJoueur;
import noyauFonctionnel.controller.ControlJeu;
import noyauFonctionnel.entity.Joueur;
import noyauFonctionnel.entity.cartes.Carte;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wer
 */
public class MainConsole {
    private Scanner scanner;
    private Joueur j1;
    private Joueur j2;
    private ControlJeu controllerJeu;
    private ControlChoisirNomJoueur controllerNom;
    
    public MainConsole(ControlJeu controllerJeu, ControlChoisirNomJoueur controllerNom) {  
        this.controllerJeu = controllerJeu;
        this.controllerNom = controllerNom;
        this.scanner = new Scanner(System.in);
        this.j1 = controllerJeu.getJoueur1();
        this.j2 = controllerJeu.getJoueur2();
    }
    
    public void lancerJeu() {
        System.out.println("Début du jeu !");
        String nomJ1;
        do {
            System.out.print("Joueur 1, entrez votre nom : ");
            nomJ1 = scanner.nextLine();
        } while (nomJ1.trim().isEmpty());
        
        controllerNom.setNomJoueur1(nomJ1);

        String nomJ2;
        do {
            System.out.print("Joueur 2, Entrez votre nom : ");
            nomJ2 = scanner.nextLine();
        } while (nomJ2.trim().isEmpty());

        controllerNom.setNomJoueur2(nomJ2);
        
        while (!controllerJeu.verifierFinPartie()) {            
            System.out.println("######################################################################################");
            System.out.println(controllerJeu.afficherJeu());
            System.out.println("######################################################################################");
            
            Joueur current = controllerJeu.getTourDeJeu() ? j1 : j2;
            
            System.out.println("\nTour de joueur " + current.getNom());
            
            int indexCarte = -1;
            do {
                System.out.print("Choisissez une carte (index entre 1 et 4) : ");

                if (scanner.hasNextInt()) {
                    indexCarte = scanner.nextInt();
                } else {
                    System.out.println("Entrée invalide. Veuillez entrer un entier.");
                    scanner.next();
                }
            } while (indexCarte < 1 || indexCarte > 4);

            List<Integer> mainJoueurCurr = controllerJeu.getTourDeJeu() ? controllerJeu.getMainJoueur1() : controllerJeu.getMainJoueur2();
            System.out.println("mainJoueurCurr = " + mainJoueurCurr);
            int carteChoisie = mainJoueurCurr.get(indexCarte - 1);
            System.out.println("carte choisie = " + carteChoisie);
            
            controllerJeu.deposerCarte(carteChoisie);   
            controllerJeu.appliquerEffetCarte(carteChoisie);
            System.out.println("ici");
            controllerJeu.removeCarteMainJoueur(carteChoisie);
            controllerJeu.joueurPrendreCarte(controllerJeu.piocher());
            
            System.out.println("On change de Joueur.");
            controllerJeu.changerJoueur();
        }
        Joueur joueurGagnant = controllerJeu.giveJoueurGagnant();
        System.out.println("\nOn a un gagnant ! Le joueur "+ joueurGagnant.getNom() + " a gagné !!!");
        scanner.close();
    }
}
