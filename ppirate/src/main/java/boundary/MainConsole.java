package boundary;

import java.util.Scanner;
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
    private Jeu jeu;
    private Scanner scanner;
    private Joueur j1;
    private Joueur j2;
    
    public MainConsole(Jeu jeu) {
        this.jeu = jeu;
        this.scanner = new Scanner(System.in);
        this.j1 = jeu.getJoueur1();
        this.j2 = jeu.getJoueur2();
    }
    
    public void lancerJeu() {
        System.out.println("Début du jeu !");
        while (!jeu.verifierFinPartie()) {
            System.out.println("######################################################################################");
            System.out.println(jeu.toString());
            System.out.println("######################################################################################");
            
            Joueur current = jeu.donnerTourDeJoueur();
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
            
            jeu.deposerCarte(carte_choisie);
            jeu.appliquerEffetCarte(carte_choisie);
            current.getMainJoueur().getCartes().remove(carte_choisie);
            current.getMainJoueur().prendreCarte(jeu.getPioche().piocher());
            
            System.out.println("On change de Joueur.");
            jeu.changerJoueur();
        }
        Joueur joueurGagnant = jeu.giveJoueurGagnant();
        System.out.println("\nOn a un gagnant ! Le joueur "+ joueurGagnant.getNom() + " a gagné !!!");
        scanner.close();
    }
}
