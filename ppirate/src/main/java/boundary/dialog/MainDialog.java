/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.dialog;

import boundary.AdaptateurDuNoyauFonctionnel;
import boundary.presentation.Plateau;
import javax.swing.Timer;

/**
 *
 * @author ember
 */
public class MainDialog {
    private AdaptateurDuNoyauFonctionnel adaptateurNoyau;
    
    public MainDialog(AdaptateurDuNoyauFonctionnel noyau) {
        this.adaptateurNoyau = noyau;
    }
    
    public void initDialog() {
        Plateau vuePlateau = new Plateau(adaptateurNoyau);
        vuePlateau.setVisible(true);
        
        Timer boucleJeu = new Timer(60000, e -> {
            System.out.println(adaptateurNoyau.getControlJoueur().getMainJoueur1().getCartes());
            System.out.println(adaptateurNoyau.getControlJoueur().getMainJoueur2().getCartes());
            vuePlateau.updatePlateau();
            if (adaptateurNoyau.getControlJeu().verifierFinPartie()) {
                // TODO logique de fin de partie (arrêter le timer)
            }
            // TODO drag and drop
            System.out.println("Une carte a été choisie.");
            // adaptateurNoyau.getControlJeu().appliquerEffetCarte(/*carte*/);
            System.out.println("On applique les effets de la carte choisie");
            // adaptateurNoyau.getControlJeu().deposerCarte(/*carte*/);
            System.out.println("carte déposée de sa zone");
            adaptateurNoyau.getControlJeu().joueurPrendreCarte(adaptateurNoyau.getControlPioche().piocher());
            System.out.println("On pioche une nouvelle carte.");
            vuePlateau.updateMainJoueur();
            vuePlateau.updatePlateau();
            adaptateurNoyau.getControlJeu().changerJoueur();
            System.out.println("On change de joueur.");
        });
        boucleJeu.start();
        
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        AdaptateurDuNoyauFonctionnel jeu = new AdaptateurDuNoyauFonctionnel();
        MainDialog dialog = new MainDialog(jeu);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dialog.initDialog();
            }
        });
    }
}
