/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import vue.ui.presentation.ChoixNom;

/**
 *
 * @author ember
 */
public class LancementChoixNom {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChoixNom vue = new ChoixNom();
                vue.setLocationRelativeTo(null);
                vue.setVisible(true);
            }
        });
    }
}
