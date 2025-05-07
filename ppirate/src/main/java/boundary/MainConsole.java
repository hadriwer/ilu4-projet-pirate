package boundary;

import java.util.Scanner;
import noyauFonctionnel.controller.ControlChoisirNomJoueur;
import noyauFonctionnel.controller.ControlJeu;
import noyauFonctionnel.entity.Jeu;
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

        j1.setNom(nomJ1);

        String nomJ2;
        do {
            System.out.print("Joueur 2, Entrez votre nom : ");
            nomJ2 = scanner.nextLine();
        } while (nomJ2.trim().isEmpty());

        j2.setNom(nomJ2);
        
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

            Carte carteChoisie = current.getMainJoueur().getCartes().get(indexCarte - 1);
            
            controllerJeu.deposerCarte(carteChoisie);
            controllerJeu.appliquerEffetCarte(carteChoisie);
            current.getMainJoueur().getCartes().remove(carteChoisie);
            current.getMainJoueur().prendreCarte(controllerJeu.piocher());
            
            System.out.println("On change de Joueur.");
            controllerJeu.changerJoueur();
        }
        Joueur joueurGagnant = controllerJeu.giveJoueurGagnant();
        System.out.println("\nOn a un gagnant ! Le joueur "+ joueurGagnant.getNom() + " a gagné !!!");
        scanner.close();
    }
}
