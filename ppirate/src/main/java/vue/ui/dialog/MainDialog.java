/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import java.awt.Component;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import util.EnumCarte;
import vue.ui.presentation.Plateau;
import vue.ui.presentation.CartePanel;
import vue.ui.presentation.ChoixNom;
import vue.ui.presentation.FinPartie;
import vue.ui.presentation.components.ViePanel;

/**
 *
 * @author Enzo, Solène, Hadrien
 */
public class MainDialog {
    private final AdaptateurDuNoyauFonctionnel adaptateurNoyau;
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
    
    public boolean handleJoueur1Gagne() {
        return adaptateurNoyau.joueur1gagne();
    }
    
    public boolean handleJoueur2Gagne() {
        return adaptateurNoyau.joueur2gagne();
    }
    
    public boolean handleJoueur1Perdu() {
        return adaptateurNoyau.joueur1perdu();
    }
    
    public boolean handleJoueur2Perdu() {
        return adaptateurNoyau.joueur2perdu();
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
    
    public void handleJoueurPioche() {
        int idCarte= adaptateurNoyau.piocher();
        adaptateurNoyau.joueurPrendreCarte(idCarte);
    }
    
    public void handleChangerJoueur() {
        adaptateurNoyau.changerJoueur();
    }
    
    public void handleTerminerJeu() {
        JDialog fenetreFin = new FinPartie(vuePlateau, true, this);
        vuePlateau.setVisible(false);
        fenetreFin.setVisible(true);
    }
    
    
    private CartePanel findCartePanelById(JPanel panel, int idCarte) {
        for (var comp : panel.getComponents()) {
            if (comp instanceof CartePanel cartePanel && cartePanel.getId() == idCarte) {
                return cartePanel;
            }
        }
        return null;
    }
    
    public CompletableFuture<Void> animateCartePanel(CartePanel carteJ1, CartePanel carteJ2, JPanel glassPane) {
        CompletableFuture<Void> future = new CompletableFuture<>();

        Timer t = new Timer(10, e -> {
            if (carteJ1.getLocation().y <= 0) {
                ((Timer) e.getSource()).stop();
                glassPane.remove(carteJ1);
                glassPane.remove(carteJ2);
                future.complete(null); // signale que l'animation est finie
            } else {
                carteJ1.setLocation(carteJ1.getLocation().x, carteJ1.getLocation().y - 8);
                carteJ2.setLocation(carteJ2.getLocation().x, carteJ2.getLocation().y + 8);
                glassPane.revalidate();
                glassPane.repaint();
            }
        });

        t.start();
        return future;
    }
    
    public void setAllMainInteractivity(boolean enabled) {
        for (Component c : vuePlateau.getMainJoueurPanel1().getComponents()) {
            if (c instanceof CartePanel cartePanel) {
                if (enabled) {
                    cartePanel.reAddInteractivity();
                } else {
                    cartePanel.removeInteractivity();
                }
            }
        }

        for (Component c : vuePlateau.getMainJoueurPanel2().getComponents()) {
            if (c instanceof CartePanel cartePanel) {
                if (enabled) {
                    cartePanel.reAddInteractivity();
                } else {
                    cartePanel.removeInteractivity();
                }
            }
        }
    }
    
    public void handleAppliquerEffetCarte(CartePanel carte) {
        // check si c un echange :
        EnumCarte type = carte.getType();//adaptateurNoyau.getType(idCarte);
        Set<Integer> mainJ1original = new HashSet<>(adaptateurNoyau.getMainJoueur1());
        Set<Integer> mainJ2original = new HashSet<>(adaptateurNoyau.getMainJoueur2());
        // difference entre getMains ici
        // dans tous les cas on applique ça
        adaptateurNoyau.appliquerEffetCarte(carte.getId());
        if (type == EnumCarte.ECHANGE) {
            // remove all interactivy
            setAllMainInteractivity(false);
            
            Set<Integer> mainJ1final = new HashSet<>(adaptateurNoyau.getMainJoueur1());
            Set<Integer> mainJ2final = new HashSet<>(adaptateurNoyau.getMainJoueur2());
            mainJ1original.removeAll(mainJ1final);
            int idCarteJ1 = mainJ1original.iterator().next();
            mainJ2original.removeAll(mainJ2final);
            int idCarteJ2 = mainJ2original.iterator().next();
            
            JPanel glassPane = (JPanel) vuePlateau.getGlassPane();
            
            CartePanel carteEchangeJ1 = findCartePanelById(vuePlateau.getMainJoueurPanel1(), idCarteJ1);
            JPanel ancienParentCarteEchangeJ1 = (JPanel) carteEchangeJ1.getParent();

            ancienParentCarteEchangeJ1.revalidate();
            ancienParentCarteEchangeJ1.repaint();
            ancienParentCarteEchangeJ1.doLayout();
            Point carteSurEcran = SwingUtilities.convertPoint(ancienParentCarteEchangeJ1,carteEchangeJ1.getLocation(), glassPane);
            
            //on enlève la carte de la main du joueur
            ancienParentCarteEchangeJ1.remove(carteEchangeJ1);
            ancienParentCarteEchangeJ1.revalidate();
            ancienParentCarteEchangeJ1.repaint();
            
            
            // carte joueur 2 échange : même code
            CartePanel carteEchangeJ2 = findCartePanelById(vuePlateau.getMainJoueurPanel2(), idCarteJ2);
            JPanel ancienParentCarteEchangeJ2 = (JPanel) carteEchangeJ2.getParent();

            ancienParentCarteEchangeJ2.revalidate();
            ancienParentCarteEchangeJ2.repaint();
            ancienParentCarteEchangeJ2.doLayout();
            Point carteSurEcran2 = SwingUtilities.convertPoint(ancienParentCarteEchangeJ2,carteEchangeJ2.getLocation(), glassPane);
            
            //on enlève la carte de la main du joueur
            ancienParentCarteEchangeJ2.remove(carteEchangeJ1);
            ancienParentCarteEchangeJ2.revalidate();
            ancienParentCarteEchangeJ2.repaint();
            
            
            glassPane.setLayout(null);
            glassPane.setVisible(true);
            glassPane.add(carteEchangeJ1);
            glassPane.add(carteEchangeJ2);
            carteEchangeJ1.setBounds(carteSurEcran.x, carteSurEcran.y, carteEchangeJ1.getPreferredSize().width, carteEchangeJ1.getPreferredSize().height);
            carteEchangeJ2.setBounds(carteSurEcran2.x, carteSurEcran2.y, carteEchangeJ2.getPreferredSize().width, carteEchangeJ2.getPreferredSize().height);

            glassPane.revalidate();
            glassPane.repaint();
            
            animateCartePanel(carteEchangeJ1, carteEchangeJ2, glassPane).thenRun(() -> {
                // Code ici exécuté APRÈS la fin de l’animation
                setAllMainInteractivity(true);
                carte.afterMouseReleased();
            });
            
        } else {
            carte.afterMouseReleased();
        }
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
            case ECHANGE -> {
            	// aucun traitement
            }
            case GAIN_VIE -> c.setGainVie(adaptateurNoyau.getGainVie(idCarte));
            case PROTECTION -> {
                c.setProtection(adaptateurNoyau.getNomAttaqueBloque(idCarte));
                c.setToolTipText("Protège de " + "\"" + adaptateurNoyau.getNomAttaqueBloque(idCarte) + "\"");
            }
            default -> System.err.println("Mauvais type de carte");
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
            vuePlateau.getZoneAction().removeAll();
            List<Integer> listZoneAction= adaptateurNoyau.getZoneAction();
            CartePanel c=extractCardPanel(listZoneAction.get(listZoneAction.size() - 1), false);
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
    
    public void lancerFinJeu() {
        java.awt.EventQueue.invokeLater(this::handleTerminerJeu);
    }
    
    public void lancerApp() {
        java.awt.EventQueue.invokeLater(this::initAccueil);
    }
    
    public void updateNbCartes(){
        int nbCartes = adaptateurNoyau.getNbCartesRestantes();
        vuePlateau.getPioche().setNbCartes(nbCartes);    
    }
}
