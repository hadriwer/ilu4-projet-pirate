package noyauFonctionnel.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.cartes.*;
import util.EnumCarte;

class JeuTest {

	private Jeu jeu;
    private Pioche pioche;
    private Attaque carteAttaque;
    private Popularite cartePopularite;
    private Echange carteEchange;
    private GainVie carteGainVie;
    private Protection carteProtection;

    @BeforeEach
    void setUp() {
        carteAttaque = new Attaque(1, "Attaque", "desc", 2, 0);
        cartePopularite = new Popularite(2,"Popularite", "desc", 1, 1);
        carteEchange = new Echange(3, "Echange", "desc");
        carteGainVie = new GainVie(4, "GainVie", "desc", 2);
        carteProtection = new Protection(5, "Protection", "desc", carteAttaque);
        
        List<Carte> cartes = new ArrayList<>();
        for (int i = 0; i < 10; i++) 
            cartes.add(cartePopularite);

        DictionnaireCarte dictCarte = new DictionnaireCarte();
        dictCarte.setCartes(cartes.toArray(new Carte[0]));
        
        pioche = new Pioche(dictCarte);
     
        jeu = new Jeu(pioche);
        
        jeu.setJoueur1Nom("Jack");
        jeu.setJoueur2Nom("Paul");
    }
    
    
    @Test
    public void testDonnerTourDeJoueur2() {
    	jeu.changerJoueur();
        assertEquals("Paul", jeu.donnerTourDeJoueur().getNom());
    }
    
    
    @Test
    public void testChangerJoueur() {
    	jeu.changerJoueur();
    	jeu.changerJoueur();
        assertEquals("Jack", jeu.donnerTourDeJoueur().getNom());
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
    public void testGiveJoueurGagnant1() {    	
    	jeu.getJoueur2().perdreVie(5);
    	assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
    	
    	jeu.getJoueur2().gagnerVie(5);
    	jeu.getJoueur1().gagnerPop(5);
    	assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
    }
    
    
    @Test
    public void testGiveJoueurGagnant2() {    	
    	jeu.getJoueur1().perdreVie(5);
    	assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
    	
    	jeu.getJoueur1().gagnerVie(5);
    	jeu.getJoueur2().gagnerPop(5);
    	assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
    }
    
    
    @Test
    public void testGiveJoueurGagnantFalse() {    	
    	assertNull(jeu.giveJoueurGagnant());
    }
    

}
