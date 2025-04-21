/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.dialog;

import boundary.AdaptateurDuNoyauFonctionnel;
import boundary.presentation.Plateau;

/**
 *
 * @author ember
 */
public class MainDialog {
    
    private AdaptateurDuNoyauFonctionnel jeu;
    
    public MainDialog(AdaptateurDuNoyauFonctionnel jeu) {
        this.jeu = jeu;
    }
    
    public void initDialog() {
        Plateau vuePlateau = new Plateau(jeu);
        vuePlateau.setVisible(true);
        // interfaceNoyauFonct
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        AdaptateurDuNoyauFonctionnel jeu = new AdaptateurDuNoyauFonctionnel();
        MainDialog dialog = new MainDialog(jeu);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialog.initDialog();
            }
        });
    }
}
