/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.presentation.components;

/**
 *
 * @author Solène
 */
public class JaugeDeViePanel extends javax.swing.JPanel {

    /**
     * Creates new form JaugeDeVie
     */
    public JaugeDeViePanel() {
        initComponents();
        vie1.setPleine(true);
        vie2.setPleine(true);
        vie3.setPleine(true);
        vie4.setPleine(false);
        vie5.setPleine(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vie1 = new boundary.presentation.components.ViePanel();
        vie2 = new boundary.presentation.components.ViePanel();
        vie3 = new boundary.presentation.components.ViePanel();
        vie4 = new boundary.presentation.components.ViePanel();
        vie5 = new boundary.presentation.components.ViePanel();

        setMaximumSize(new java.awt.Dimension(150, 30));
        setMinimumSize(new java.awt.Dimension(150, 30));
        setPreferredSize(new java.awt.Dimension(150, 30));
        setLayout(new java.awt.GridLayout(1, 5));

        javax.swing.GroupLayout vie1Layout = new javax.swing.GroupLayout(vie1);
        vie1.setLayout(vie1Layout);
        vie1Layout.setHorizontalGroup(
            vie1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vie1Layout.setVerticalGroup(
            vie1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(vie1);

        javax.swing.GroupLayout vie2Layout = new javax.swing.GroupLayout(vie2);
        vie2.setLayout(vie2Layout);
        vie2Layout.setHorizontalGroup(
            vie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vie2Layout.setVerticalGroup(
            vie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(vie2);

        javax.swing.GroupLayout vie3Layout = new javax.swing.GroupLayout(vie3);
        vie3.setLayout(vie3Layout);
        vie3Layout.setHorizontalGroup(
            vie3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vie3Layout.setVerticalGroup(
            vie3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(vie3);

        javax.swing.GroupLayout vie4Layout = new javax.swing.GroupLayout(vie4);
        vie4.setLayout(vie4Layout);
        vie4Layout.setHorizontalGroup(
            vie4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vie4Layout.setVerticalGroup(
            vie4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(vie4);

        javax.swing.GroupLayout vie5Layout = new javax.swing.GroupLayout(vie5);
        vie5.setLayout(vie5Layout);
        vie5Layout.setHorizontalGroup(
            vie5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vie5Layout.setVerticalGroup(
            vie5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(vie5);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private boundary.presentation.components.ViePanel vie1;
    private boundary.presentation.components.ViePanel vie2;
    private boundary.presentation.components.ViePanel vie3;
    private boundary.presentation.components.ViePanel vie4;
    private boundary.presentation.components.ViePanel vie5;
    // End of variables declaration//GEN-END:variables
}
