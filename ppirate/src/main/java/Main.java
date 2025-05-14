
import boundary.MainConsole;
import noyauFonctionnel.controller.ControlCarte;
import noyauFonctionnel.controller.ControlChoisirNomJoueur;
import noyauFonctionnel.controller.ControlJeu;
import noyauFonctionnel.entity.DictionnaireCarte;
import noyauFonctionnel.entity.Jeu;
import noyauFonctionnel.entity.Pioche;
import vue.ui.dialog.AdaptateurDuNoyauFonctionnel;
import vue.ui.dialog.MainDialog;


/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wer
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le mode de jeu :");
        System.out.println("1. Console (boundary)");
        System.out.println("2. Interface graphique (vue)");
        System.out.print("Votre choix (1 ou 2) : ");

        String choix = scanner.nextLine();

        // Initialisation commune
        DictionnaireCarte dictionnaireCarte = new DictionnaireCarte();
        Pioche pioche = new Pioche(dictionnaireCarte);
        Jeu jeu = new Jeu(pioche);

        ControlJeu controlJeu = new ControlJeu(jeu, dictionnaireCarte);
        ControlChoisirNomJoueur controlChoisirNomJoueur = new ControlChoisirNomJoueur(jeu);
        ControlCarte controlCarte = new ControlCarte(dictionnaireCarte);

        AdaptateurDuNoyauFonctionnel adaptateurNoyau = new AdaptateurDuNoyauFonctionnel(controlJeu, controlChoisirNomJoueur, controlCarte);
        
        if (choix.equals("1")) {
            // Lancement en console
            MainConsole boundary = new MainConsole(adaptateurNoyau);
            boundary.lancerJeu();
        } else if (choix.equals("2")) {
            // Lancement en IHM
            MainDialog dialog = new MainDialog(adaptateurNoyau);
            dialog.lancerApp();
        } else {
            System.out.println("Choix invalide. Veuillez relancer le programme et choisir 1 ou 2.");
        }

        scanner.close();
    }
}
