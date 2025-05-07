/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import vue.ui.presentation.Plateau;
import vue.ui.presentation.components.TimerPanel;
import javax.swing.Timer;
import noyauFonctionnel.controller.ControlJeu;
import noyauFonctionnel.entity.cartes.Carte;
import vue.ui.presentation.CartePanel;
import vue.ui.presentation.ChoixNom;
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
    
    public AdaptateurDuNoyauFonctionnel getAdaptateurNoyau() {
        return adaptateurNoyau;
    }
    
    public void stopTimer() {
        vuePlateau.getTimerPanel().stop();
    }
    
    public void restartTimer() {
        vuePlateau.getTimerPanel().restartTimer();
    }
    
    public boolean handleVerifierFinDePartie() {
        return adaptateurNoyau.getControlJeu().verifierFinPartie();
    }
    
    public void handleDeposerCarte(Carte carte) {
        adaptateurNoyau.getControlJeu().deposerCarte(carte);
    }
    
    public void handleRemoveCarteMainJoueur(Carte carte) {
        adaptateurNoyau.getControlJeu().removeCarteMainJoueur(carte);
    }
    
    public void handleAppliquerEffetCarte(Carte carte) {
        adaptateurNoyau.getControlJeu().appliquerEffetCarte(carte);
    }
    
    public void handleJoueurPioche() {
        adaptateurNoyau.getControlJeu().joueurPrendreCarte(adaptateurNoyau.getControlJeu().piocher());
    }
    
    public void handleChangerJoueur() {
        adaptateurNoyau.getControlJeu().changerJoueur();
    }
    
    public void updateCarteZonePopularite() {
        vuePlateau.getZonePopulariteJoueur1().removeAll();
        vuePlateau.getZonePopulariteJoueur2().removeAll();

        adaptateurNoyau.getControlJeu().getZonePopulariteJ1().forEach(carte -> {
            System.out.println("Carte ajoutée dans zone Popularité du joueur 1 : " + carte);
            CartePanel c = new CartePanel(carte, false, this);
            vuePlateau.getZonePopulariteJoueur1().add(c);
        });

        adaptateurNoyau.getControlJeu().getZonePopulariteJ2().forEach(carte -> {
            System.out.println("Carte ajoutée dans zone Popularité du joueur 2 : " + carte);
            CartePanel c = new CartePanel(carte, false, this);
            vuePlateau.getZonePopulariteJoueur2().add(c);
        });
        
        vuePlateau.getZonePopulariteJoueur2().revalidate();
        vuePlateau.getZonePopulariteJoueur2().repaint();
        vuePlateau.getZonePopulariteJoueur1().revalidate();
        vuePlateau.getZonePopulariteJoueur1().repaint();
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
        boolean tourDeJeu = adaptateurNoyau.getControlJeu().getTourDeJeu();

        adaptateurNoyau.getControlJeu().getMainJoueur1().getCartes().forEach(carte -> {
            CartePanel c = new CartePanel(carte, tourDeJeu, this);
            vuePlateau.getMainJoueurPanel1().add(c);
        });
 
        adaptateurNoyau.getControlJeu().getMainJoueur2().getCartes().forEach(carte -> {
            CartePanel c = new CartePanel(carte, !tourDeJeu, this);
            vuePlateau.getMainJoueurPanel2().add(c);
        });

        vuePlateau.getMainJoueurPanel1().revalidate();
        vuePlateau.getMainJoueurPanel1().repaint();
        vuePlateau.getMainJoueurPanel2().revalidate();
        vuePlateau.getMainJoueurPanel2().repaint();
    }
    
    public void updateJaugeVie() {
        int vie_j1 = adaptateurNoyau.getControlJeu().getPointDeVieJ1();
        int vie_j2 = adaptateurNoyau.getControlJeu().getPointDeVieJ2();

        for (int i = 0; i < 5; i++) {
            ViePanel viesJ1 = (ViePanel) vuePlateau.getJaugeVieJ1().getComponent(i);
            ViePanel viesJ2 = (ViePanel) vuePlateau.getJaugeVieJ2().getComponent(i);

            viesJ1.setPleine(i < vie_j1);
            viesJ2.setPleine(i < vie_j2);
        }
    }
    
    public void updatePopularite() {
        int pop_j1 = adaptateurNoyau.getControlJeu().getIndicePopulariteJ1();
        int pop_j2 = adaptateurNoyau.getControlJeu().getIndicePopulariteJ2();

        vuePlateau.getJaugePopJ1().setNiveau(pop_j1);
        vuePlateau.getJaugePopJ2().setNiveau(pop_j2);
    }

    public void updateZoneAction() {
        if (!adaptateurNoyau.getControlJeu().getZoneAction().isEmpty()) {
            System.out.println("zone action rempli");
            vuePlateau.getZoneAction().removeAll();
            CartePanel premCarte = new CartePanel(adaptateurNoyau.getControlJeu().getZoneAction().getLast(), false, this);
            vuePlateau.getZoneAction().add(premCarte);
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
        
            vuePlateau.getTimerPanel().getTimer().start();
            getAdaptateurNoyau().getControlChoisirNomJoueur().setNomJoueur1(nomJoueur1);
            getAdaptateurNoyau().getControlChoisirNomJoueur().setNomJoueur2(nomJoueur2);
        }
    }
    
    public void initAccueil() {
        vueAccueil = new ChoixNom(this);
        vueAccueil.setLocationRelativeTo(null);
        vueAccueil.setVisible(true);
    }
    
    public void lancerApp() {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAccueil();
            }
        });
    }
    
    public void updateNbCartes(){
        int nbCartes = adaptateurNoyau.getControlJeu().getNbCartesRestantes();
        vuePlateau.getPioche().setNbCartes(nbCartes);    
    }
}
