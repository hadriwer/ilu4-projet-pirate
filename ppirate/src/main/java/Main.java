
import noyauFonctionnel.controller.ControlJouerCarte;
import noyauFonctionnel.controller.ControlPiocherCarte;
import noyauFonctionnel.entity.Jeu;


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
        
        ControlJouerCarte controlJouerCarte = new ControlJouerCarte(jeu);
        ControlPiocherCarte controlPiocherCarte = new ControlPiocherCarte(jeu);
        
        System.out.println(controlJouerCarte);
        System.out.println(controlPiocherCarte);
    }
}
