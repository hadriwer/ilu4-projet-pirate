package noyaufonctionnel.entity;

import noyaufonctionnel.entity.cartes.GainVie;
import noyaufonctionnel.entity.cartes.Protection;
import noyaufonctionnel.entity.cartes.Echange;
import noyaufonctionnel.entity.cartes.Popularite;
import noyaufonctionnel.entity.cartes.Attaque;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class JeuTest {

	private Jeu jeu;
    private Pioche pioche;
    private Attaque carteAttaque;
    private Popularite cartePopularite;
    private Echange carteEchange;
    private GainVie carteGainVie;
    private Protection carteProtection;
    private DictionnaireCarte dictCarte;

    @BeforeEach
    public void setUp() {
        carteAttaque = new Attaque(1, "Attaque", "desc", 2, 0);
        cartePopularite = new Popularite(2,"Popularite", "desc", 1, 1);
        carteEchange = new Echange(3, "Echange", "desc");
        carteGainVie = new GainVie(4, "GainVie", "desc", 2);
        carteProtection = new Protection(5, "Protection", "desc", carteAttaque);

        dictCarte = new DictionnaireCarte();
        
        pioche = new Pioche(dictCarte);
     
        jeu = new Jeu(pioche);
        
        jeu.setJoueur1Nom("Jack");
        jeu.setJoueur2Nom("Paul");
    }
    
    
    @Test
    void testDonnerTourDeJoueur2() {
    	jeu.changerJoueur();
    	assertEquals("Paul", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());
    }
    
    
    @Test
    void testChangerJoueur() {
    	jeu.changerJoueur();
    	jeu.changerJoueur();
    	assertEquals("Jack", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());
    }
    
    
    
    @Test
    void testDeposerCarteDansAction() {
        jeu.deposerCarte(carteAttaque);
        assertTrue(jeu.getZoneAction().contains(carteAttaque));
        
        jeu.deposerCarte(carteEchange);
        assertTrue(jeu.getZoneAction().contains(carteEchange));
        
        jeu.deposerCarte(carteGainVie);
        assertTrue(jeu.getZoneAction().contains(carteEchange));
    }
    
    
    @Test
    void testDeposerCarteDansPopularite() {
        jeu.deposerCarte(cartePopularite);
        assertTrue(jeu.getZonePopulariteJ1().contains(cartePopularite));
        
        jeu.changerJoueur();
        jeu.deposerCarte(carteProtection);
        assertTrue(jeu.getZonePopulariteJ2().contains(carteProtection));
    }
    
    
    @Test
    void testVerifierFinPartieFalse() {
        assertFalse(jeu.verifierFinPartie());
    }

    
    @Test
    void testVerifierFinPartieGagnantJ1Pop() {    	
        jeu.getJoueur1().gagnerPop(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
   
    @Test
    void testVerifierFinPartieGagnantJ2Pop() {    	
        jeu.getJoueur2().gagnerPop(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
    
    @Test
    void testVerifierFinPartiePerdantJ1Vie() {    	
        jeu.getJoueur1().perdreVie(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
   
    @Test
    void testVerifierFinPartiePerdantJ2Vie() {    	
        jeu.getJoueur2().perdreVie(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
    
    @Test
    void testGiveJoueurGagnantJ1Gagne() {    	
    	jeu.getJoueur1().gagnerPop(5);
    	assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
    }
    
   
    @Test
    void testGiveJoueurGagnantJ2Perd() {    	
    	jeu.getJoueur2().perdreVie(5);
    	assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
    }
    
    
    @Test
    void testGiveJoueurGagnantJ2Gagne() {    	
    	jeu.getJoueur2().gagnerPop(5);
    	assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
    }
    
   
    @Test
    void testGiveJoueurGagnantJ1Perd() {    	
    	jeu.getJoueur1().perdreVie(5);
    	assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
    }
    
    
    @Test
    void testGiveJoueurGagnantFalse() {    	
    	assertNull(jeu.giveJoueurGagnant());
    }
    
    
    @Test
    void testJoueurPrendreEtRemoveJ1() {
    	// Test Prendre
    	jeu.joueurPrendreCarte(carteAttaque);
    	assertTrue(jeu.getJoueur1().getMainJoueur().getCartes().contains(carteAttaque));
    	
    	// Test Remove
    	jeu.removeCarteMainJoueur(carteAttaque);
    	assertFalse(jeu.getJoueur1().getMainJoueur().getCartes().contains(carteAttaque));
    	
    }
    
    
    @Test
    void testJoueurPrendreEtRemoveJ2() {
    	// Test Prendre
    	jeu.changerJoueur();
    	jeu.joueurPrendreCarte(carteAttaque);
    	assertTrue(jeu.getJoueur2().getMainJoueur().getCartes().contains(carteAttaque));
    	
    	// Test Remove
    	jeu.removeCarteMainJoueur(carteAttaque);
    	assertFalse(jeu.getJoueur2().getMainJoueur().getCartes().contains(carteAttaque));
    	
    }
    
    
    @Test 
    void testAppliquerEffetCarte() {
    	// pour J1
        jeu.appliquerEffetCarte(cartePopularite);
        assertEquals(1, jeu.getJoueur1().getIndicePopularite());
        
        // pour J2
        jeu.changerJoueur();
        jeu.appliquerEffetCarte(cartePopularite);
        assertEquals(1, jeu.getJoueur2().getIndicePopularite());
    }
    
    
    @Test
    void testGetPioche() {
    	assertEquals(pioche, jeu.getPioche());
    }
    
    
    @Test
    void testGetJoueur1Nom() {
    	assertEquals("Jack", jeu.getJoueur1Nom());
    }
    
    
    @Test
    void testGetJoueur2Nom() {
    	assertEquals("Paul", jeu.getJoueur2Nom());
    }
    
    
    @Test
    void testGetTourDeJeu() {
    	// Si True => tour de J1
    	assertTrue(jeu.getTourDeJeu());
    	
    	// Si False => tour de J2
    	jeu.changerJoueur();
    	assertFalse(jeu.getTourDeJeu());
    }
    
    
    @Test
    void testToString() {
    	// tour de J1
    	jeu.deposerCarte(cartePopularite);
        String result = jeu.toString();
        assertTrue(result.contains("Joueur[nom=Jack, vie=5, popularite=0, contenu de la main=("));
        assertTrue(result.contains("Zone de Popularité J1: [Popularite[nom=Popularite, gain=1, auto-degat=1] ]"));
        assertTrue(result.contains("Zone d'action : vide"));
        
        // tour de J2
        jeu.changerJoueur();
        jeu.deposerCarte(cartePopularite);
        jeu.deposerCarte(carteAttaque);
        result = jeu.toString();
        assertTrue(result.contains("Joueur[nom=Paul, vie=5, popularite=0, contenu de la main=("));
        assertTrue(result.contains("Zone de Popularité J2: [Popularite[nom=Popularite, gain=1, auto-degat=1] ]"));
        assertTrue(result.contains("Zone d'action : Attaque[nom=Attaque, degat=2, auto-degat=0]"));
        
    }
    
}
