
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
public class Main {
    public static void main(String[] args) {
        //testFonctionnel.TestUnitaire.main(args);
        DictionnaireCarte dictionnaireCarte = new DictionnaireCarte();
        Pioche pioche = new Pioche(dictionnaireCarte);
        Jeu jeu = new Jeu(pioche);
        
        ControlJeu controlJeu=new ControlJeu(jeu, dictionnaireCarte);
        ControlChoisirNomJoueur controlChoisirNomJoueur=new ControlChoisirNomJoueur(jeu);
        ControlCarte controlCarte=new ControlCarte(dictionnaireCarte);
        
        // Pour la partie présentation (IHM)
        AdaptateurDuNoyauFonctionnel noyau = new AdaptateurDuNoyauFonctionnel(controlJeu,controlChoisirNomJoueur,controlCarte);
        MainDialog dialog = new MainDialog(noyau);
      
        dialog.lancerApp();
        
        // Pour la partie Boundary
        //MainConsole boundary = new MainConsole(new ControlJeu(jeu, dictionnaireCarte), new ControlChoisirNomJoueur(jeu));
        // boundary.lancerJeu();
        
        // TODO
    }
}
