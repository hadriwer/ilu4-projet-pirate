/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.presentation.components;

import boundary.presentation.ChargeurImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import util.EnumJoueur;

/**
 *
 * @author Solène
 */
public class ProfilJoueurPanel extends javax.swing.JPanel {

    private EnumJoueur joueur;

    public EnumJoueur getJoueur() {
        return joueur;
    }

    public void setJoueur(EnumJoueur joueur) {
        this.joueur = joueur;
        setImage(joueur);
    }

    
    /**
     * Creates new form ProfilJoueurPanel
     */
    public ProfilJoueurPanel() {
        initComponents();
    }

    public void setImage(EnumJoueur joueur){
        BufferedImage image=ChargeurImage.chargerImage("presentation/"+joueur.toString().toLowerCase()+"_joueur.png");
        Image imageEchelle;
        imageEchelle = image.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon typeIcon=new ImageIcon(imageEchelle);
        iconLabel.setIcon(typeIcon);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(130, 130));

        iconLabel.setPreferredSize(new java.awt.Dimension(280, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    // End of variables declaration//GEN-END:variables
}
