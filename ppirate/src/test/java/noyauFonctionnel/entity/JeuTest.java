package noyauFonctionnel.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.cartes.*;

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
    public void testDonnerTourDeJoueur2() {
    	jeu.changerJoueur();
    	assertEquals("Paul", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());
    }
    
    
    @Test
    public void testChangerJoueur() {
    	jeu.changerJoueur();
    	jeu.changerJoueur();
    	assertEquals("Jack", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());
    }
    
    
    
    @Test
    public void testDeposerCarteDansAction() {
        jeu.deposerCarte(carteAttaque);
        assertTrue(jeu.getZoneAction().contains(carteAttaque));
        
        jeu.deposerCarte(carteEchange);
        assertTrue(jeu.getZoneAction().contains(carteEchange));
        
        jeu.deposerCarte(carteGainVie);
        assertTrue(jeu.getZoneAction().contains(carteEchange));
    }
    
    
    @Test
    public void testDeposerCarteDansPopularite() {
        jeu.deposerCarte(cartePopularite);
        assertTrue(jeu.getZonePopulariteJ1().contains(cartePopularite));
        
        jeu.changerJoueur();
        jeu.deposerCarte(carteProtection);
        assertTrue(jeu.getZonePopulariteJ2().contains(carteProtection));
    }
    
    
    @Test
    public void testVerifierFinPartieFalse() {
        assertFalse(jeu.verifierFinPartie());
    }

    
    @Test
    public void testVerifierFinPartieGagnantJ1Pop() {    	
        jeu.getJoueur1().gagnerPop(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
   
    @Test
    public void testVerifierFinPartieGagnantJ2Pop() {    	
        jeu.getJoueur2().gagnerPop(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
    
    @Test
    public void testVerifierFinPartiePerdantJ1Vie() {    	
        jeu.getJoueur1().perdreVie(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
   
    @Test
    public void testVerifierFinPartiePerdantJ2Vie() {    	
        jeu.getJoueur2().perdreVie(5);
        assertTrue(jeu.verifierFinPartie());
    }
    
    
    @Test
    public void testGiveJoueurGagnantJ1Gagne() {    	
    	jeu.getJoueur1().gagnerPop(5);
    	assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
    }
    
   
    @Test
    public void testGiveJoueurGagnantJ2Perd() {    	
    	jeu.getJoueur2().perdreVie(5);
    	assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
    }
    
    
    @Test
    public void testGiveJoueurGagnantJ2Gagne() {    	
    	jeu.getJoueur2().gagnerPop(5);
    	assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
    }
    
   
    @Test
    public void testGiveJoueurGagnantJ1Perd() {    	
    	jeu.getJoueur1().perdreVie(5);
    	assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
    }
    
    
    @Test
    public void testGiveJoueurGagnantFalse() {    	
    	assertNull(jeu.giveJoueurGagnant());
    }
    
    
    @Test
    public void testJoueurPrendreEtRemoveJ1() {
    	// Test Prendre
    	jeu.joueurPrendreCarte(carteAttaque);
    	assertTrue(jeu.getJoueur1().getMainJoueur().getCartes().contains(carteAttaque));
    	
    	// Test Remove
    	jeu.removeCarteMainJoueur(carteAttaque);
    	assertFalse(jeu.getJoueur1().getMainJoueur().getCartes().contains(carteAttaque));
    	
    }
    
    
    @Test
    public void testJoueurPrendreEtRemoveJ2() {
    	// Test Prendre
    	jeu.changerJoueur();
    	jeu.joueurPrendreCarte(carteAttaque);
    	assertTrue(jeu.getJoueur2().getMainJoueur().getCartes().contains(carteAttaque));
    	
    	// Test Remove
    	jeu.removeCarteMainJoueur(carteAttaque);
    	assertFalse(jeu.getJoueur2().getMainJoueur().getCartes().contains(carteAttaque));
    	
    }
    
    
    @Test 
    public void testAppliquerEffetCarte() {
    	// pour J1
        jeu.appliquerEffetCarte(cartePopularite);
        assertEquals(1, jeu.getJoueur1().getIndicePopularite());
        
        // pour J2
        jeu.changerJoueur();
        jeu.appliquerEffetCarte(cartePopularite);
        assertEquals(1, jeu.getJoueur2().getIndicePopularite());
    }
    
    
    @Test
    public void testGetPioche() {
    	assertEquals(pioche, jeu.getPioche());
    }
    
    
    @Test
    public void testGetJoueur1Nom() {
    	assertEquals("Jack", jeu.getJoueur1Nom());
    }
    
    
    @Test
    public void testGetJoueur2Nom() {
    	assertEquals("Paul", jeu.getJoueur2Nom());
    }
    
    
    @Test
    public void testGetTourDeJeu() {
    	// Si True => tour de J1
    	assertTrue(jeu.getTourDeJeu());
    	
    	// Si False => tour de J2
    	jeu.changerJoueur();
    	assertFalse(jeu.getTourDeJeu());
    }
    
    
    @Test
    public void testToString() {
    	// tour de J1
    	jeu.deposerCarte(cartePopularite);
        jeu.toString();
        
        // tour de J2
        jeu.changerJoueur();
        jeu.deposerCarte(cartePopularite);
        jeu.deposerCarte(carteAttaque);
        jeu.toString();
    }
    
}
