
import boundary.MainConsole;
import noyauFonctionnel.controller.ControlJouerCarte;
import noyauFonctionnel.controller.ControlPioche;
import noyauFonctionnel.entity.Jeu;
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
        Jeu jeu = new Jeu();
        
        // Pour la partie présentation (IHM)
        
        AdaptateurDuNoyauFonctionnel noyau = new AdaptateurDuNoyauFonctionnel(jeu);
        MainDialog dialog = new MainDialog(noyau);
      
        // dialog.main();
        
        // Pour la partie Boundary
        
        MainConsole boundary = new MainConsole(jeu);
        boundary.lancerJeu();
        
        // TODO
    }
}
