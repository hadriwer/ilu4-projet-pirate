/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import util.EnumCarte;
import static util.EnumCarte.ATTAQUE;
import static util.EnumCarte.POPULARITE;
import vue.ui.presentation.Plateau;
import vue.ui.presentation.CartePanel;
import vue.ui.presentation.ChoixNom;
import vue.ui.presentation.FinPartie;
import vue.ui.presentation.components.ViePanel;

/**
 *
 * @author ember
 */
public class MainDialog {
    private AdaptateurDuNoyauFonctionnel adaptateurNoyau;
    private Plateau vuePlateau;
    private ChoixNom vueAccueil;

    
    public MainDialog(AdaptateurDuNoyauFonctionnel noyau) {
        this.adaptateurNoyau = noyau;
    }
    
    public void stopTimer() {
        vuePlateau.getTimerPanel().stop();
    }
    
    public void restartTimer() {
        vuePlateau.getTimerPanel().restartTimer();
    }
    
    public boolean handleVerifierFinDePartie() {
        return adaptateurNoyau.verifierFinPartie();
    }
    
    public void handleDeposerCarte(int idCarte) {
        adaptateurNoyau.deposerCarte(idCarte);
    }
    
    public void handleRemoveCarteMainJoueur(int idCarte) {
        adaptateurNoyau.removeCarteMainJoueur(idCarte);
    }
    
    public void handleAppliquerEffetCarte(int idCarte) {
        adaptateurNoyau.appliquerEffetCarte(idCarte);
    }
    
    public void handleJoueurPioche() {
        int idCarte= adaptateurNoyau.piocher();
        adaptateurNoyau.joueurPrendreCarte(idCarte);
    }
    
    public void handleChangerJoueur() {
        adaptateurNoyau.changerJoueur();
    }
    
    public void handleTerminerJeu() {
        JDialog fenetreFin = new FinPartie(vuePlateau, true);
        fenetreFin.setVisible(true);
    }
    
    public CartePanel extractCardPanel(int idCarte, boolean enabled){
        EnumCarte type = adaptateurNoyau.getType(idCarte);
        String nom = adaptateurNoyau.getNom(idCarte);
        String description = adaptateurNoyau.getDescription(idCarte);
        CartePanel c = new CartePanel(this, idCarte, type, nom, description);
        c.setEnabled(enabled);
        switch (type) {
            case ATTAQUE -> {
                c.setActionVie(adaptateurNoyau.getActionVie(idCarte));
                if (adaptateurNoyau.getSelfDegat(idCarte) != 0){
                    c.setSelfDegat(adaptateurNoyau.getSelfDegat(idCarte));
                }
            }
            case POPULARITE -> {
                c.setPointPopularite(adaptateurNoyau.getPointPopularite(idCarte));
                if (adaptateurNoyau.getSelfDegat(idCarte) != 0){
                    c.setSelfDegat(adaptateurNoyau.getSelfDegat(idCarte));
                }
            }
            case GAIN_VIE -> {
                c.setGainVie(adaptateurNoyau.getGainVie(idCarte));
            }
            case PROTECTION -> {
                c.setProtection(adaptateurNoyau.getNomAttaqueBloque(idCarte));
                c.setToolTipText("Protège de " + "\"" + adaptateurNoyau.getNomAttaqueBloque(idCarte) + "\"");
            }
            default -> {
            }
        }
        return c;
    }
    
    public void updateCarteZonePopularite() {
        vuePlateau.getZonePopulariteJoueur1().removeAll();
        vuePlateau.getZonePopulariteJoueur2().removeAll();

        List<Integer> listCarteZP1= adaptateurNoyau.getZonePopulariteJ1();
        List<Integer> listCarteZP2= adaptateurNoyau.getZonePopulariteJ2();
        
        listCarteZP1.forEach(idCarte -> {
            CartePanel c=extractCardPanel(idCarte, false);
            vuePlateau.getZonePopulariteJoueur1().add(c);
        });
        
        listCarteZP2.forEach(idCarte -> {
            CartePanel c=extractCardPanel(idCarte, false);
            vuePlateau.getZonePopulariteJoueur2().add(c);
        });

        vuePlateau.getZonePopulariteJoueur1().revalidate();
        vuePlateau.getZonePopulariteJoueur1().repaint();
        vuePlateau.getZonePopulariteJoueur2().revalidate();
        vuePlateau.getZonePopulariteJoueur2().repaint();
    }
    
    public final void updatePlateau() {
        updateCarteZonePopularite();
        updateJaugeVie();
        updatePopularite();
        updateMainJoueur();
        updateZoneAction();
    } 

    public void updateMainJoueur() {
        vuePlateau.getMainJoueurPanel1().removeAll();
        vuePlateau.getMainJoueurPanel2().removeAll();

        List<Integer> listCarteMJ1= adaptateurNoyau.getMainJoueur1();
        List<Integer> listCarteMJ2= adaptateurNoyau.getMainJoueur2();
        
        // true si c'est le tour du joueur 1
        boolean tourJoueur1 = adaptateurNoyau.getTourDeJeu();
        if (tourJoueur1){
            vuePlateau.setTour(adaptateurNoyau.getNomJoueur1());
        }else{
            vuePlateau.setTour(adaptateurNoyau.getNomJoueur2());
        }
        
        listCarteMJ1.forEach(idCarte -> {
            CartePanel c=extractCardPanel(idCarte, tourJoueur1);
            vuePlateau.getMainJoueurPanel1().add(c);
        });
        
        listCarteMJ2.forEach(idCarte -> {
            CartePanel c=extractCardPanel(idCarte, !tourJoueur1);
            vuePlateau.getMainJoueurPanel2().add(c);
        });

        vuePlateau.getMainJoueurPanel1().revalidate();
        vuePlateau.getMainJoueurPanel1().repaint();
        vuePlateau.getMainJoueurPanel2().revalidate();
        vuePlateau.getMainJoueurPanel2().repaint();
    }
    
    public void updateJaugeVie() {
        int vieJ1 = adaptateurNoyau.getPointDeVieJ1();
        int vieJ2 = adaptateurNoyau.getPointDeVieJ2();

        for (int i = 0; i < 5; i++) {
            ViePanel panelViesJ1 = (ViePanel) vuePlateau.getJaugeVieJ1().getComponent(i);
            ViePanel panelViesJ2 = (ViePanel) vuePlateau.getJaugeVieJ2().getComponent(i);

            panelViesJ1.setPleine(i < vieJ1);
            panelViesJ2.setPleine(i < vieJ2);
        }
    }
    
    public void updatePopularite() {
        int popJ1 = adaptateurNoyau.getIndicePopulariteJ1();
        int popJ2 = adaptateurNoyau.getIndicePopulariteJ2();

        vuePlateau.getJaugePopJ1().setNiveau(popJ1);
        vuePlateau.getJaugePopJ2().setNiveau(popJ2);
    }

    public void updateZoneAction() {
        if (!adaptateurNoyau.getZoneAction().isEmpty()) {
            System.out.println("zone action rempli");
            vuePlateau.getZoneAction().removeAll();
            List<Integer> listZoneAction= adaptateurNoyau.getZoneAction();
            CartePanel c=extractCardPanel(listZoneAction.getLast(), false);
            vuePlateau.getZoneAction().add(c);
        }
        vuePlateau.getZoneAction().revalidate();
        vuePlateau.getZoneAction().repaint();
    }
    
    public Plateau getPlateau() {
        return vuePlateau;
    }
    
    public void submitNomsJoueurs(String nomJoueur1, String nomJoueur2) {
        if (nomJoueur1.isEmpty() || nomJoueur2.isEmpty()) {
            vueAccueil.getErreurLabel().setText("Un des deux pseudos est non renseigné !");
        } else {
            vueAccueil.setVisible(false);
            vueAccueil.dispose();
            vuePlateau = new Plateau(this);
            vuePlateau.setLocationRelativeTo(null);
            vuePlateau.setVisible(true);
            updatePlateau();
            
            vuePlateau.getLabelJ1().setText(nomJoueur1);
            vuePlateau.getLabelJ2().setText(nomJoueur2);
            vuePlateau.setTour(nomJoueur1);
        
            vuePlateau.getTimerPanel().getTimer().start();
            adaptateurNoyau.setNomJoueur1(nomJoueur1);
            adaptateurNoyau.setNomJoueur2(nomJoueur2);
        }
    }
    
    public void initAccueil() {
        vueAccueil = new ChoixNom(this);
        vueAccueil.setLocationRelativeTo(null);
        vueAccueil.setVisible(true);
    }
    
    public void lancerApp() {
        java.awt.EventQueue.invokeLater(this::initAccueil);
    }
    
    public void updateNbCartes(){
        int nbCartes = adaptateurNoyau.getNbCartesRestantes();
        vuePlateau.getPioche().setNbCartes(nbCartes);    
    }
}
