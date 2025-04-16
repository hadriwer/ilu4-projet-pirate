/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.dialog;

import boundary.presentation.Plateau;

/**
 *
 * @author ember
 */
public class MainDialog {
    
    public void initDialog() {
        Plateau vuePlateau = new Plateau();
        vuePlateau.setVisible(true);
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MainDialog dialog = new MainDialog();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialog.initDialog();
            }
        });
    }
}
