/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package boundary.presentation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.Joueur;

/**
 *
 * @author ember
 */
public class Plateau extends javax.swing.JFrame {

    /**
     * Creates new form Plateau
     */
    public Plateau() {
        initComponents();
        setImage();
    }

    public void setImage(){
        BufferedImage image=ChargeurImage.chargerImage("presentation/plateau_background.png");
        Image imageEchelle;
        imageEchelle = image.getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon typeIcon=new ImageIcon(imageEchelle);
        backgroundLabel.setIcon(typeIcon);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelJoueur2 = new javax.swing.JPanel();
        panelInfosJ2 = new javax.swing.JPanel();
        jaugeDePopularitePanel2 = new boundary.presentation.components.JaugeDePopularitePanel();
        jaugeDeViePanel2 = new boundary.presentation.components.JaugeDeViePanel();
        profilJoueurPanel2 = new boundary.presentation.components.ProfilJoueurPanel();
        panelMainJ2 = new javax.swing.JPanel();
        fillerMain1J2 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(60, 32767));
        cartePanel8 = new boundary.presentation.CartePanel();
        fillerEspaceCarte1J2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        cartePanel7 = new boundary.presentation.CartePanel();
        fillerEspaceCarte2J2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        cartePanel6 = new boundary.presentation.CartePanel();
        fillerEspaceCarte3J2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        cartePanel5 = new boundary.presentation.CartePanel();
        fillerMain2J2 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(60, 32767));
        panelDescriptionCarte = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panelCommun = new javax.swing.JPanel();
        panelZonesPopularite = new javax.swing.JPanel();
        zonePopularitePanel1 = new boundary.presentation.components.ZonePopularitePanel();
        zonePopularitePanel2 = new boundary.presentation.components.ZonePopularitePanel();
        panelZoneAction = new javax.swing.JPanel();
        fillerZoneAction1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 150), new java.awt.Dimension(32767, 50));
        panelZoneAction1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        fillerZoneAction2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        panelPioche = new javax.swing.JPanel();
        fillerPioche1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 150), new java.awt.Dimension(32767, 50));
        pioche1 = new boundary.presentation.components.Pioche();
        fillerPioche2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        panelJoueur1 = new javax.swing.JPanel();
        panelInfosJ1 = new javax.swing.JPanel();
        jaugeDePopularitePanel1 = new boundary.presentation.components.JaugeDePopularitePanel();
        jaugeDeViePanel1 = new boundary.presentation.components.JaugeDeViePanel();
        profilJoueurPanel1 = new boundary.presentation.components.ProfilJoueurPanel();
        panelMainJ1 = new javax.swing.JPanel();
        fillerMain1J1 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(60, 32767));
        cartePanel2 = new boundary.presentation.CartePanel();
        fillerEspaceCarte1J1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        cartePanel1 = new boundary.presentation.CartePanel();
        fillerEspaceCarte2J1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        cartePanel3 = new boundary.presentation.CartePanel();
        fillerEspaceCarte3J1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        cartePanel4 = new boundary.presentation.CartePanel();
        fillerMain2J1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(100, 32767));
        timerPanel1 = new boundary.presentation.components.TimerPanel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jLayeredPane1.setLayout(new java.awt.BorderLayout());

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
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelInfosJ2.add(jaugeDePopularitePanel2, java.awt.BorderLayout.EAST);

        jaugeDeViePanel2.setOpaque(false);
        panelInfosJ2.add(jaugeDeViePanel2, java.awt.BorderLayout.SOUTH);
        panelInfosJ2.add(profilJoueurPanel2, java.awt.BorderLayout.CENTER);

        panelJoueur2.add(panelInfosJ2, java.awt.BorderLayout.WEST);

        panelMainJ2.setOpaque(false);
        panelMainJ2.setLayout(new javax.swing.BoxLayout(panelMainJ2, javax.swing.BoxLayout.LINE_AXIS));
        panelMainJ2.add(fillerMain1J2);

        cartePanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel8MousePressed(evt);
            }
        });
        panelMainJ2.add(cartePanel8);
        panelMainJ2.add(fillerEspaceCarte1J2);

        cartePanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel7MousePressed(evt);
            }
        });
        panelMainJ2.add(cartePanel7);
        panelMainJ2.add(fillerEspaceCarte2J2);

        cartePanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel6MousePressed(evt);
            }
        });
        panelMainJ2.add(cartePanel6);
        panelMainJ2.add(fillerEspaceCarte3J2);

        cartePanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel5MousePressed(evt);
            }
        });
        panelMainJ2.add(cartePanel5);
        panelMainJ2.add(fillerMain2J2);

        panelDescriptionCarte.setBackground(new java.awt.Color(0, 102, 102));

        jLabel14.setText("DESC");
        panelDescriptionCarte.add(jLabel14);

        panelMainJ2.add(panelDescriptionCarte);

        panelJoueur2.add(panelMainJ2, java.awt.BorderLayout.CENTER);

        jLayeredPane1.add(panelJoueur2, java.awt.BorderLayout.NORTH);

        panelCommun.setOpaque(false);
        panelCommun.setLayout(new java.awt.BorderLayout());

        panelZonesPopularite.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelZonesPopularite.setOpaque(false);
        panelZonesPopularite.setLayout(new java.awt.GridLayout(2, 0));

        javax.swing.GroupLayout zonePopularitePanel1Layout = new javax.swing.GroupLayout(zonePopularitePanel1);
        zonePopularitePanel1.setLayout(zonePopularitePanel1Layout);
        zonePopularitePanel1Layout.setHorizontalGroup(
            zonePopularitePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        zonePopularitePanel1Layout.setVerticalGroup(
            zonePopularitePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        panelZonesPopularite.add(zonePopularitePanel1);

        javax.swing.GroupLayout zonePopularitePanel2Layout = new javax.swing.GroupLayout(zonePopularitePanel2);
        zonePopularitePanel2.setLayout(zonePopularitePanel2Layout);
        zonePopularitePanel2Layout.setHorizontalGroup(
            zonePopularitePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        zonePopularitePanel2Layout.setVerticalGroup(
            zonePopularitePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

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

        panelPioche.setPreferredSize(new java.awt.Dimension(100, 26));
        panelPioche.setLayout(new java.awt.GridLayout(3, 0));
        panelPioche.add(fillerPioche1);
        panelPioche.add(pioche1);
        panelPioche.add(fillerPioche2);

        panelCommun.add(panelPioche, java.awt.BorderLayout.EAST);

        jLayeredPane1.add(panelCommun, java.awt.BorderLayout.CENTER);

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
        panelInfosJ1.add(profilJoueurPanel1, java.awt.BorderLayout.CENTER);

        panelJoueur1.add(panelInfosJ1, java.awt.BorderLayout.WEST);

        panelMainJ1.setOpaque(false);
        panelMainJ1.setLayout(new javax.swing.BoxLayout(panelMainJ1, javax.swing.BoxLayout.LINE_AXIS));
        panelMainJ1.add(fillerMain1J1);

        cartePanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel2MousePressed(evt);
            }
        });
        panelMainJ1.add(cartePanel2);
        panelMainJ1.add(fillerEspaceCarte1J1);

        cartePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel1MousePressed(evt);
            }
        });
        panelMainJ1.add(cartePanel1);
        panelMainJ1.add(fillerEspaceCarte2J1);

        cartePanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel3MousePressed(evt);
            }
        });
        panelMainJ1.add(cartePanel3);
        panelMainJ1.add(fillerEspaceCarte3J1);

        cartePanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartePanel4MousePressed(evt);
            }
        });
        panelMainJ1.add(cartePanel4);
        panelMainJ1.add(fillerMain2J1);
        panelMainJ1.add(timerPanel1);

        panelJoueur1.add(panelMainJ1, java.awt.BorderLayout.CENTER);

        jLayeredPane1.add(panelJoueur1, java.awt.BorderLayout.SOUTH);

        backgroundLabel.setMaximumSize(new java.awt.Dimension(1080, 720));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(1080, 720));
        backgroundLabel.setOpaque(true);
        backgroundLabel.setPreferredSize(new java.awt.Dimension(1080, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backgroundLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backgroundLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cartePanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel1MousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        System.out.println("boundary.presentation.Plateau.formMousePressed()");
    }//GEN-LAST:event_formMousePressed

    private void cartePanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel2MousePressed

    private void cartePanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel3MousePressed

    private void cartePanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel4MousePressed

    private void cartePanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel5MousePressed

    private void cartePanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel6MousePressed

    private void cartePanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel7MousePressed

    private void cartePanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartePanel8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartePanel8MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private boundary.presentation.CartePanel cartePanel1;
    private boundary.presentation.CartePanel cartePanel2;
    private boundary.presentation.CartePanel cartePanel3;
    private boundary.presentation.CartePanel cartePanel4;
    private boundary.presentation.CartePanel cartePanel5;
    private boundary.presentation.CartePanel cartePanel6;
    private boundary.presentation.CartePanel cartePanel7;
    private boundary.presentation.CartePanel cartePanel8;
    private javax.swing.Box.Filler fillerEspaceCarte1J1;
    private javax.swing.Box.Filler fillerEspaceCarte1J2;
    private javax.swing.Box.Filler fillerEspaceCarte2J1;
    private javax.swing.Box.Filler fillerEspaceCarte2J2;
    private javax.swing.Box.Filler fillerEspaceCarte3J1;
    private javax.swing.Box.Filler fillerEspaceCarte3J2;
    private javax.swing.Box.Filler fillerMain1J1;
    private javax.swing.Box.Filler fillerMain1J2;
    private javax.swing.Box.Filler fillerMain2J1;
    private javax.swing.Box.Filler fillerMain2J2;
    private javax.swing.Box.Filler fillerPioche1;
    private javax.swing.Box.Filler fillerPioche2;
    private javax.swing.Box.Filler fillerZoneAction1;
    private javax.swing.Box.Filler fillerZoneAction2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLayeredPane jLayeredPane1;
    private boundary.presentation.components.JaugeDePopularitePanel jaugeDePopularitePanel1;
    private boundary.presentation.components.JaugeDePopularitePanel jaugeDePopularitePanel2;
    private boundary.presentation.components.JaugeDeViePanel jaugeDeViePanel1;
    private boundary.presentation.components.JaugeDeViePanel jaugeDeViePanel2;
    private javax.swing.JPanel panelCommun;
    private javax.swing.JPanel panelDescriptionCarte;
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
    private boundary.presentation.components.Pioche pioche1;
    private boundary.presentation.components.ProfilJoueurPanel profilJoueurPanel1;
    private boundary.presentation.components.ProfilJoueurPanel profilJoueurPanel2;
    private boundary.presentation.components.TimerPanel timerPanel1;
    private boundary.presentation.components.ZonePopularitePanel zonePopularitePanel1;
    private boundary.presentation.components.ZonePopularitePanel zonePopularitePanel2;
    // End of variables declaration//GEN-END:variables
}
