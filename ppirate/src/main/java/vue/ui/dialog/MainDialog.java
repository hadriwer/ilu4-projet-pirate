/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import javax.swing.JOptionPane;
import vue.ui.presentation.Plateau;
import vue.ui.presentation.components.TimerPanel;
import javax.swing.Timer;

/**
 *
 * @author ember
 */
public class MainDialog {
    private AdaptateurDuNoyauFonctionnel adaptateurNoyau;
    private int numTour;
    
    public MainDialog(AdaptateurDuNoyauFonctionnel noyau) {
        this.adaptateurNoyau = noyau;
        this.numTour = 0;
    }
    
    public void initDialog() {
        //String joueur1 = demanderNom("joueur 1");
        //if (joueur1 == null) System.exit(0);

        //String joueur2 = demanderNom("joueur 2");
        //if (joueur2 == null) System.exit(0);

        // System.out.println("Joueur 1 : " + joueur1);
        // System.out.println("Joueur 2 : " + joueur2);
    
        Plateau vuePlateau = new Plateau(adaptateurNoyau);
        TimerPanel timerPanel = vuePlateau.getTimerPanel();
        vuePlateau.setVisible(true);
        vuePlateau.updatePlateau();
        
        Timer boucleJeu = new Timer(10000, e -> {
            this.numTour += 1;
            System.out.println("Début du Tour numéro : " + numTour);
            System.out.println("Le pirate " + adaptateurNoyau.getControlJeu().donnerTourDeJoueur());
            timerPanel.updateTimer(timerPanel.getDecompte());
            if (adaptateurNoyau.getControlJeu().verifierFinPartie()) {
                // TODO logique de fin de partie (arrêter le timer)
            }
            // TODO drag and drop
            System.out.println("Une carte a été choisie.");
            
            // adaptateurNoyau.getControlJeu().appliquerEffetCarte(/*carte*/);
            System.out.println("On applique les effets de la carte choisie");
            
            // adaptateurNoyau.getControlJeu().deposerCarte(/*carte*/);
            System.out.println("carte déposée de sa zone");
            
            // adaptateurNoyau.getControlJeu().joueurPrendreCarte(adaptateurNoyau.getControlPioche().piocher());
            // vuePlateau.updateMainJoueur();
            System.out.println("On pioche une nouvelle carte.");
            
            adaptateurNoyau.getControlJeu().changerJoueur();
            System.out.println("On change de joueur.\n");
            vuePlateau.updatePlateau();
            timerPanel.restartTimer();
        });
        boucleJeu.start();
    }
    
    private String demanderNom(String label) {
        while (true) {
            String nom = JOptionPane.showInputDialog(null, "Nom de " + label + " :", "Inscription", JOptionPane.PLAIN_MESSAGE);
            if (nom == null) return null;
            if (!nom.trim().isEmpty()) return nom.trim();
            JOptionPane.showMessageDialog(null, "Votre nom ne peut pas être vide");
        }
    }
    
     /**
     * @param args the command line arguments
     */
    public void main() {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                initDialog();
            }
        });
    }
}
