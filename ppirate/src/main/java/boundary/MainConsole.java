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
        while (!controllerJeu.verifierFinPartie()) {
            System.out.println("######################################################################################");
            System.out.println(controllerJeu.afficherJeu());
            System.out.println("######################################################################################");
            
            Joueur current = controllerJeu.getTourDeJeu() ? j1 : j2;
            System.out.println("\nC'est au joueur " + current.getNom() + " de jouer."); 
            
            System.out.println("Choisissez une carte mettre un index entre 1 et 4");
            int index_carte = -1;
            while (index_carte < 1 || index_carte > 4) {
                if (scanner.hasNextInt()) {
                    index_carte = scanner.nextInt();
                }
                else {
                    scanner.next();
                }
            }
            Carte carte_choisie = current.getMainJoueur().getCartes().get(index_carte - 1);
            
            controllerJeu.deposerCarte(carte_choisie);
            controllerJeu.appliquerEffetCarte(carte_choisie);
            current.getMainJoueur().getCartes().remove(carte_choisie);
            current.getMainJoueur().prendreCarte(controllerJeu.piocher());
            
            System.out.println("On change de Joueur.");
            controllerJeu.changerJoueur();
        }
        Joueur joueurGagnant = controllerJeu.giveJoueurGagnant();
        System.out.println("\nOn a un gagnant ! Le joueur "+ joueurGagnant.getNom() + " a gagné !!!");
        scanner.close();
    }
}
