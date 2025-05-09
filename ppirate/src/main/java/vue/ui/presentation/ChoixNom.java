/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vue.ui.presentation;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import vue.ui.dialog.MainDialog;

/**
 *
 * @author ember
 */
public class ChoixNom extends javax.swing.JFrame {
    private MainDialog dialog;
    
    
    /**
     * Creates new form Plateau
     * 
     * @param dialog
     */
    public ChoixNom(MainDialog dialog) {
        this.dialog = dialog;
        initComponents();
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        setImage();
        setResizable(false);
        
        pirate2Field.setPlaceholder("Jack Sparrow");
        pirate1Field.setPlaceholder("Barbe noire");
        pirate2Field.setBorder(new EmptyBorder(10, 10, 10, 10));
        pirate1Field.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        BufferedImage icon = ChargeurImage.chargerImage("presentation/icon_ppirate.png");
        Image iconResize = icon.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        this.setIconImage(iconResize);

        
        BufferedImage image = ChargeurImage.chargerImage("presentation/logo_ppirate.png");

        int taille = 250;

        Image imageEchelle = image.getScaledInstance(taille, taille, Image.SCALE_SMOOTH);
        ImageIcon typeIcon = new ImageIcon(imageEchelle);
        logoLabel.setIcon(typeIcon);
        logoLabel.setPreferredSize(new Dimension(taille, taille));
        logoLabel.setMinimumSize(new Dimension(taille, taille));
        logoLabel.setMaximumSize(new Dimension(taille, taille));

        startButton.setText("LANCER LE JEU");
        startButton.setBorder(new EmptyBorder(10, 10, 10, 10));

        
        BufferedImage image2 = ChargeurImage.chargerImage("presentation/enter_game.png");
        Image imageEchelle2;
        imageEchelle2 = image2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon typeIcon2 = new ImageIcon(imageEchelle2);
        startButton.setIcon(typeIcon2);
    }

    public void setImage() {
        BufferedImage image = ChargeurImage.chargerImage("presentation/plateau_background.png");
        Image imageEchelle;
        imageEchelle = image.getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon typeIcon = new ImageIcon(imageEchelle);
        backgroundLabel.setIcon(typeIcon);
    }
    
    public javax.swing.JLabel getErreurLabel() {
        return this.labelErreur;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panelGaucheLogo = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        panelDroiteField = new javax.swing.JPanel();
        pirate1et2Panel = new javax.swing.JPanel();
        pirate1Panel = new javax.swing.JPanel();
        pirate1nom = new javax.swing.JLabel();
        pirate1Field = new vue.ui.presentation.components.CustomJTextField();
        pirate2Panel = new javax.swing.JPanel();
        pirate2nomLabel = new javax.swing.JLabel();
        pirate2Field = new vue.ui.presentation.components.CustomJTextField();
        startPanel = new javax.swing.JPanel();
        labelErreur = new javax.swing.JLabel();
        startButton = new vue.ui.presentation.components.CustomJButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        backgroundPanel = new javax.swing.JPanel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 320));
        setMinimumSize(new java.awt.Dimension(480, 320));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        mainPanel.setMaximumSize(new java.awt.Dimension(480, 320));
        mainPanel.setMinimumSize(new java.awt.Dimension(480, 320));
        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(480, 320));
        mainPanel.setLayout(new java.awt.GridLayout(1, 0));

        panelGaucheLogo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelGaucheLogo.setOpaque(false);
        panelGaucheLogo.setLayout(new java.awt.BorderLayout());

        logoLabel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        logoLabel.setMinimumSize(new java.awt.Dimension(1000, 1000));
        logoLabel.setName(""); // NOI18N
        logoLabel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelGaucheLogo.add(logoLabel, java.awt.BorderLayout.CENTER);

        mainPanel.add(panelGaucheLogo);

        panelDroiteField.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panelDroiteField.setOpaque(false);
        panelDroiteField.setLayout(new java.awt.GridLayout(2, 0));

        pirate1et2Panel.setOpaque(false);
        pirate1et2Panel.setLayout(new java.awt.GridLayout(2, 0));

        pirate1Panel.setOpaque(false);
        pirate1Panel.setLayout(new java.awt.BorderLayout());

        pirate1nom.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pirate1nom.setForeground(new java.awt.Color(204, 204, 204));
        pirate1nom.setText("Pirate n°1:");
        pirate1Panel.add(pirate1nom, java.awt.BorderLayout.CENTER);
        pirate1Panel.add(pirate1Field, java.awt.BorderLayout.SOUTH);

        pirate1et2Panel.add(pirate1Panel);

        pirate2Panel.setOpaque(false);
        pirate2Panel.setLayout(new java.awt.BorderLayout());

        pirate2nomLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pirate2nomLabel.setForeground(new java.awt.Color(204, 204, 204));
        pirate2nomLabel.setText("Pirate n°2:");
        pirate2Panel.add(pirate2nomLabel, java.awt.BorderLayout.CENTER);
        pirate2Panel.add(pirate2Field, java.awt.BorderLayout.SOUTH);

        pirate1et2Panel.add(pirate2Panel);

        panelDroiteField.add(pirate1et2Panel);

        startPanel.setOpaque(false);
        startPanel.setLayout(new java.awt.GridLayout(3, 0));

        labelErreur.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        labelErreur.setForeground(new java.awt.Color(255, 51, 51));
        startPanel.add(labelErreur);

        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        startPanel.add(startButton);
        startPanel.add(filler2);

        panelDroiteField.add(startPanel);

        mainPanel.add(panelDroiteField);

        getContentPane().add(mainPanel);

        backgroundPanel.setMaximumSize(new java.awt.Dimension(480, 320));
        backgroundPanel.setMinimumSize(new java.awt.Dimension(480, 320));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(480, 320));

        backgroundLabel.setMaximumSize(new java.awt.Dimension(480, 320));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(480, 320));
        backgroundLabel.setOpaque(true);
        backgroundLabel.setPreferredSize(new java.awt.Dimension(480, 320));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(backgroundPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        dialog.submitNomsJoueurs(pirate1Field.getText(), pirate2Field.getText());
    }//GEN-LAST:event_startButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel labelErreur;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelDroiteField;
    private javax.swing.JPanel panelGaucheLogo;
    private vue.ui.presentation.components.CustomJTextField pirate1Field;
    private javax.swing.JPanel pirate1Panel;
    private javax.swing.JPanel pirate1et2Panel;
    private javax.swing.JLabel pirate1nom;
    private vue.ui.presentation.components.CustomJTextField pirate2Field;
    private javax.swing.JPanel pirate2Panel;
    private javax.swing.JLabel pirate2nomLabel;
    private vue.ui.presentation.components.CustomJButton startButton;
    private javax.swing.JPanel startPanel;
    // End of variables declaration//GEN-END:variables
}
