/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vue.ui.presentation;

import vue.ui.dialog.AdaptateurDuNoyauFonctionnel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import util.EnumJoueur;
import vue.ui.dialog.MainDialog;
import vue.ui.presentation.components.TimerPanel;
import vue.ui.presentation.components.ViePanel;

/**
 *
 * @author ember
 */
public class Plateau extends javax.swing.JFrame {
    private AdaptateurDuNoyauFonctionnel noyau;
    private MainDialog dialog;

    /**
     * Creates new form Plateau
     * 
     * @param dialog
     */
    public Plateau(MainDialog dialog) {
        this.dialog = dialog;
        this.noyau = dialog.getAdaptateurNoyau();
        initComponents();
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        setImage();
        setResizable(false);
        profilJoueurPanel1.setJoueur(EnumJoueur.JACK_LE_BORGNE);
        profilJoueurPanel2.setJoueur(EnumJoueur.BILL_JAMBE_DE_BOIS);

        afficherCarteZonePopularite();

        // Set Adaptateur Noyau Fonctionnel
        pioche1.setAdaptateur(noyau);
    }

    public void setImage() {
        BufferedImage image = ChargeurImage.chargerImage("presentation/plateau_background.png");
        Image imageEchelle;
        imageEchelle = image.getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon typeIcon = new ImageIcon(imageEchelle);
        backgroundLabel.setIcon(typeIcon);
    }

    public AdaptateurDuNoyauFonctionnel getAdaptateurNoyau() {
        return noyau;
    }

    public void afficherCarteZonePopularite() {
        zonePopularitePanel1.removeAll();
        zonePopularitePanel2.removeAll();

        noyau.getControlJeu().getZonePopulariteJ1().forEach(carte -> {
            System.out.println("Carte ajoutée dans zone Popularité du joueur 1 : " + carte);
            CartePanel c = new CartePanel(carte, false);
            zonePopularitePanel1.add(c);
        });

        noyau.getControlJeu().getZonePopulariteJ2().forEach(carte -> {
            System.out.println("Carte ajoutée dans zone Popularité du joueur 2 : " + carte);
            CartePanel c = new CartePanel(carte, false);
            zonePopularitePanel2.add(c);
        });

        zonePopularitePanel1.revalidate();
        zonePopularitePanel1.repaint();
        zonePopularitePanel2.revalidate();
        zonePopularitePanel2.repaint();
    }
    
    public final void updatePlateau() {
        afficherCarteZonePopularite();
        updateJaugeVie();
        updatePopularite();
        updateMainJoueur();
        updateZoneAction();
    } 

    public void updateMainJoueur() {
        mainJoueurPanel1.removeAll();
        mainJoueurPanel2.removeAll();
        boolean tourDeJeu = noyau.getControlJeu().getTourDeJeu();

        noyau.getControlJoueur().getMainJoueur1().getCartes().forEach(carte -> {
            CartePanel c = new CartePanel(carte, tourDeJeu);
            mainJoueurPanel1.add(c);
        });
 
        noyau.getControlJoueur().getMainJoueur2().getCartes().forEach(carte -> {
            CartePanel c = new CartePanel(carte, !tourDeJeu);
            mainJoueurPanel2.add(c);
        });

        mainJoueurPanel1.revalidate();
        mainJoueurPanel1.repaint();
        mainJoueurPanel2.revalidate();
        mainJoueurPanel2.repaint();
    }
    
    public void updateJaugeVie() {
        int vie_j1 = noyau.getControlJoueur().getPointDeVieJ1();
        int vie_j2 = noyau.getControlJoueur().getPointDeVieJ2();

        for (int i = 0; i < 5; i++) {
            if (i <= vie_j1) {
                ViePanel vies = (ViePanel) jaugeDeViePanel1.getComponent(i);
                vies.setPleine(true);
            }
            if (i <= vie_j2) {
                ViePanel vies = (ViePanel) jaugeDeViePanel2.getComponent(i);
                vies.setPleine(true);
            }
        }
    }
    
    public void updatePopularite() {
        int pop_j1 = noyau.getControlJoueur().getIndicePopulariteJ1();
        int pop_j2 = noyau.getControlJoueur().getIndicePopulariteJ2();

        jaugeDePopularitePanel1.setNiveau(pop_j1);
        jaugeDePopularitePanel2.setNiveau(pop_j2);
    }

    public void updateZoneAction() {
        if (!noyau.getControlJeu().getZoneAction().isEmpty()) {
            System.out.println("zone action rempli");
            panelZoneAction1.removeAll();
            CartePanel premCarte = new CartePanel(noyau.getControlJeu().getZoneAction().getFirst(), false);
            panelZoneAction1.add(premCarte);
        }
        panelZoneAction1.revalidate();
        panelZoneAction1.repaint();
    }
    
    public TimerPanel getTimerPanel() {
        return timerPanel1;
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

        jPanel1 = new javax.swing.JPanel();
        panelCommun = new javax.swing.JPanel();
        panelZonesPopularite = new javax.swing.JPanel();
        zonePopularitePanel1 = new vue.ui.presentation.components.ZonePopularitePanel();
        zonePopularitePanel2 = new vue.ui.presentation.components.ZonePopularitePanel();
        panelZoneAction = new javax.swing.JPanel();
        fillerZoneAction1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 150), new java.awt.Dimension(32767, 50));
        panelZoneAction1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        fillerZoneAction2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        panelPioche = new javax.swing.JPanel();
        fillerPioche1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 150), new java.awt.Dimension(32767, 50));
        pioche1 = new vue.ui.presentation.components.Pioche();
        fillerPioche2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        panelJoueur1 = new javax.swing.JPanel();
        panelInfosJ1 = new javax.swing.JPanel();
        jaugeDePopularitePanel1 = new vue.ui.presentation.components.JaugeDePopularitePanel();
        jaugeDeViePanel1 = new vue.ui.presentation.components.JaugeDeViePanel();
        profilJoueurPanel1 = new vue.ui.presentation.components.ProfilJoueurPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelMainJ1 = new javax.swing.JPanel();
        filler1MainJ1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        mainJoueurPanel1 = new vue.ui.presentation.components.MainJoueurPanel();
        filler2MainJ1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 2), new java.awt.Dimension(500, 32767));
        timerPanel1 = new vue.ui.presentation.components.TimerPanel();
        panelJoueur2 = new javax.swing.JPanel();
        panelInfosJ2 = new javax.swing.JPanel();
        jaugeDePopularitePanel2 = new vue.ui.presentation.components.JaugeDePopularitePanel();
        jaugeDeViePanel2 = new vue.ui.presentation.components.JaugeDeViePanel();
        profilJoueurPanel2 = new vue.ui.presentation.components.ProfilJoueurPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelMainJ2 = new javax.swing.JPanel();
        filler1MainJ2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        mainJoueurPanel2 = new vue.ui.presentation.components.MainJoueurPanel();
        filler2MainJ2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        descriptionPanel1 = new vue.ui.presentation.components.DescriptionPanel();
        jPanel2 = new javax.swing.JPanel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(640, 360));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setOpaque(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelCommun.setOpaque(false);
        panelCommun.setLayout(new java.awt.BorderLayout());

        panelZonesPopularite.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelZonesPopularite.setOpaque(false);
        panelZonesPopularite.setLayout(new java.awt.GridLayout(2, 0));
        panelZonesPopularite.add(zonePopularitePanel1);
        panelZonesPopularite.add(zonePopularitePanel2);

        panelCommun.add(panelZonesPopularite, java.awt.BorderLayout.CENTER);

        panelZoneAction.setOpaque(false);
        panelZoneAction.setPreferredSize(new java.awt.Dimension(100, 26));
        panelZoneAction.setLayout(new java.awt.GridLayout(3, 0));
        panelZoneAction.add(fillerZoneAction1);

        panelZoneAction1.setBackground(new java.awt.Color(204, 255, 102));
        panelZoneAction1.setPreferredSize(new java.awt.Dimension(100, 26));
        panelZoneAction1.setLayout(new javax.swing.BoxLayout(panelZoneAction1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel15.setText("ACTION");
        panelZoneAction1.add(jLabel15);

        panelZoneAction.add(panelZoneAction1);
        panelZoneAction.add(fillerZoneAction2);

        panelCommun.add(panelZoneAction, java.awt.BorderLayout.WEST);

        panelPioche.setOpaque(false);
        panelPioche.setPreferredSize(new java.awt.Dimension(100, 26));
        panelPioche.setLayout(new java.awt.GridLayout(3, 0));
        panelPioche.add(fillerPioche1);
        panelPioche.add(pioche1);
        panelPioche.add(fillerPioche2);

        panelCommun.add(panelPioche, java.awt.BorderLayout.EAST);

        jPanel1.add(panelCommun, java.awt.BorderLayout.CENTER);

        panelJoueur1.setOpaque(false);
        panelJoueur1.setLayout(new java.awt.BorderLayout());

        panelInfosJ1.setOpaque(false);
        panelInfosJ1.setLayout(new java.awt.BorderLayout());

        jaugeDePopularitePanel1.setBackground(null);
        jaugeDePopularitePanel1.setOpaque(false);

        javax.swing.GroupLayout jaugeDePopularitePanel1Layout = new javax.swing.GroupLayout(jaugeDePopularitePanel1);
        jaugeDePopularitePanel1.setLayout(jaugeDePopularitePanel1Layout);
        jaugeDePopularitePanel1Layout.setHorizontalGroup(
            jaugeDePopularitePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );
        jaugeDePopularitePanel1Layout.setVerticalGroup(
            jaugeDePopularitePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        panelInfosJ1.add(jaugeDePopularitePanel1, java.awt.BorderLayout.EAST);

        jaugeDeViePanel1.setOpaque(false);
        panelInfosJ1.add(jaugeDeViePanel1, java.awt.BorderLayout.NORTH);

        profilJoueurPanel1.setOpaque(false);
        panelInfosJ1.add(profilJoueurPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JACK SPARROW");
        jPanel3.add(jLabel1);

        panelInfosJ1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        panelJoueur1.add(panelInfosJ1, java.awt.BorderLayout.WEST);

        panelMainJ1.setOpaque(false);
        panelMainJ1.setLayout(new javax.swing.BoxLayout(panelMainJ1, javax.swing.BoxLayout.LINE_AXIS));
        panelMainJ1.add(filler1MainJ1);
        panelMainJ1.add(mainJoueurPanel1);
        panelMainJ1.add(filler2MainJ1);
        panelMainJ1.add(timerPanel1);

        panelJoueur1.add(panelMainJ1, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelJoueur1, java.awt.BorderLayout.SOUTH);

        panelJoueur2.setOpaque(false);
        panelJoueur2.setLayout(new java.awt.BorderLayout());

        panelInfosJ2.setOpaque(false);
        panelInfosJ2.setLayout(new java.awt.BorderLayout());

        jaugeDePopularitePanel2.setOpaque(false);

        javax.swing.GroupLayout jaugeDePopularitePanel2Layout = new javax.swing.GroupLayout(jaugeDePopularitePanel2);
        jaugeDePopularitePanel2.setLayout(jaugeDePopularitePanel2Layout);
        jaugeDePopularitePanel2Layout.setHorizontalGroup(
            jaugeDePopularitePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jaugeDePopularitePanel2Layout.setVerticalGroup(
            jaugeDePopularitePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        panelInfosJ2.add(jaugeDePopularitePanel2, java.awt.BorderLayout.EAST);

        jaugeDeViePanel2.setOpaque(false);
        panelInfosJ2.add(jaugeDeViePanel2, java.awt.BorderLayout.SOUTH);

        profilJoueurPanel2.setOpaque(false);
        panelInfosJ2.add(profilJoueurPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JACK SPARROW");
        jPanel4.add(jLabel2);

        panelInfosJ2.add(jPanel4, java.awt.BorderLayout.NORTH);

        panelJoueur2.add(panelInfosJ2, java.awt.BorderLayout.WEST);

        panelMainJ2.setOpaque(false);
        panelMainJ2.setLayout(new javax.swing.BoxLayout(panelMainJ2, javax.swing.BoxLayout.LINE_AXIS));
        panelMainJ2.add(filler1MainJ2);
        panelMainJ2.add(mainJoueurPanel2);
        panelMainJ2.add(filler2MainJ2);

        descriptionPanel1.setPreferredSize(new java.awt.Dimension(219, 113));
        descriptionPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                descriptionPanel1MousePressed(evt);
            }
        });
        panelMainJ2.add(descriptionPanel1);

        panelJoueur2.add(panelMainJ2, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelJoueur2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1);

        backgroundLabel.setMaximumSize(new java.awt.Dimension(1080, 720));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(1080, 720));
        backgroundLabel.setOpaque(true);
        backgroundLabel.setPreferredSize(new java.awt.Dimension(1080, 720));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMousePressed
        System.out.println("vue.ui.presentation.Plateau.formMousePressed()");
    }// GEN-LAST:event_formMousePressed

    private void descriptionPanel1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_descriptionPanel1MousePressed
        // TODO add your handling code here:
        // pour l'instant le code est dans un event mousePressed mais l'idée
        // serait d'appeler la fonction losqu'une carte est jouée
        descriptionPanel1.setDescription("une description");
    }// GEN-LAST:event_descriptionPanel1MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private vue.ui.presentation.components.DescriptionPanel descriptionPanel1;
    private javax.swing.Box.Filler filler1MainJ1;
    private javax.swing.Box.Filler filler1MainJ2;
    private javax.swing.Box.Filler filler2MainJ1;
    private javax.swing.Box.Filler filler2MainJ2;
    private javax.swing.Box.Filler fillerPioche1;
    private javax.swing.Box.Filler fillerPioche2;
    private javax.swing.Box.Filler fillerZoneAction1;
    private javax.swing.Box.Filler fillerZoneAction2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private vue.ui.presentation.components.JaugeDePopularitePanel jaugeDePopularitePanel1;
    private vue.ui.presentation.components.JaugeDePopularitePanel jaugeDePopularitePanel2;
    private vue.ui.presentation.components.JaugeDeViePanel jaugeDeViePanel1;
    private vue.ui.presentation.components.JaugeDeViePanel jaugeDeViePanel2;
    private vue.ui.presentation.components.MainJoueurPanel mainJoueurPanel1;
    private vue.ui.presentation.components.MainJoueurPanel mainJoueurPanel2;
    private javax.swing.JPanel panelCommun;
    private javax.swing.JPanel panelInfosJ1;
    private javax.swing.JPanel panelInfosJ2;
    private javax.swing.JPanel panelJoueur1;
    private javax.swing.JPanel panelJoueur2;
    private javax.swing.JPanel panelMainJ1;
    private javax.swing.JPanel panelMainJ2;
    private javax.swing.JPanel panelPioche;
    private javax.swing.JPanel panelZoneAction;
    private javax.swing.JPanel panelZoneAction1;
    private javax.swing.JPanel panelZonesPopularite;
    private vue.ui.presentation.components.Pioche pioche1;
    private vue.ui.presentation.components.ProfilJoueurPanel profilJoueurPanel1;
    private vue.ui.presentation.components.ProfilJoueurPanel profilJoueurPanel2;
    private vue.ui.presentation.components.TimerPanel timerPanel1;
    private vue.ui.presentation.components.ZonePopularitePanel zonePopularitePanel1;
    private vue.ui.presentation.components.ZonePopularitePanel zonePopularitePanel2;
    // End of variables declaration//GEN-END:variables
}
