package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.List;

import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.Popularite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ember
 */
class JoueurTest {
    private Joueur joueurMainVide;
    private Joueur joueurMainPleine;
    private Popularite popularite1;
    private Attaque attaque1;

    @BeforeEach
    void setUp() {
        popularite1 = new Popularite(1,"Carte1", "desc1", 1, 1);
        attaque1 = new Attaque(2,"Carte2", "desc2", 0, 0);
        
        List<Carte> cartes = new ArrayList<>();
        
        for (int i = 0; i <4; i++)
        	cartes.add(popularite1);
        
        joueurMainPleine = new Joueur(cartes);
        joueurMainVide = new Joueur(new ArrayList<>());
        
        joueurMainPleine.setNom("Paul");
        joueurMainVide.setNom("Jack");
    }
    
    
    @Test
    void testGetNom() {
        assertEquals("Jack", joueurMainVide.getNom());
    }
    
    
    @Test
    void testSetNom() {
    	joueurMainVide.setNom("Dave");
    	assertEquals("Dave", joueurMainVide.getNom());
    }
    
    
    @Test
    void testGetIndicePopularite() {
        assertEquals(0, joueurMainVide.getIndicePopularite());
    }

    
    @Test
    void testGetIndiceVieInitial() {
        assertEquals(5, joueurMainVide.getIndiceVie());
    }
    
    
    // test de la perte de vie dans le cas normal sans dépasser 0 
    @Test
    void testPerdreVie() {
        joueurMainVide.perdreVie(1);
        assertEquals(4, joueurMainVide.getIndiceVie());
    }
    
    // test de la perte de vie dans le cas normal en dépassant 0 
    @Test
    void testPerdreVieDepassement() {
    	joueurMainVide.perdreVie(6);
        assertEquals(0, joueurMainVide.getIndiceVie());
    }
    
    
    // test du gain de vie dans le cas normal sans dépasser 5 
    @Test
    void testGagnerVie() {
    	joueurMainVide.perdreVie(2);
        joueurMainVide.gagnerVie(1);
        assertEquals(4, joueurMainVide.getIndiceVie());
    }
    
    // test du gain de vie dans le cas normal en dépassant 5 
    @Test
    void testGagnerVieDepassement() {
    	joueurMainVide.perdreVie(1);
        joueurMainVide.gagnerVie(2);
        assertEquals(5, joueurMainVide.getIndiceVie());
    }

    
    @Test
    void testGagnerPop() {
    	joueurMainVide.gagnerPop(1);
        assertEquals(1, joueurMainVide.getIndicePopularite());
    }
    
   
    @Test
    void testGagnerPopDepassement() {
    	joueurMainVide.gagnerPop(6);
        assertEquals(5, joueurMainVide.getIndicePopularite());
    }

    
    @Test
    void testAGagneFalse() {
        assertFalse(joueurMainVide.aGagne());
    }
    
    
    @Test
    void testAGagneTrue() {
    	joueurMainVide.gagnerPop(5);
    	assertTrue(joueurMainVide.aGagne()); 
    }

    
    @Test
    void testAPerduFalse() {
    	assertFalse(joueurMainVide.aPerdu());
    }
    
    
    @Test
    void testAPerduTrue() {
    	joueurMainVide.perdreVie(5);
    	assertTrue(joueurMainVide.aPerdu()); 
    }

    
    @Test
    void testToStringMainVide() {
        String expResult = "Joueur[nom=Jack, vie=5, popularite=0, contenu de la main= vide]";
        assertEquals(expResult, joueurMainVide.toString());
    }
    
    
    @Test
    void testToStringMainPleine() {
        String expResult = """
        		Joueur[nom=Paul, vie=5, popularite=0, contenu de la main=(
        		Popularite[nom=Carte1, gain=1, auto-degat=1]
        		Popularite[nom=Carte1, gain=1, auto-degat=1]
        		Popularite[nom=Carte1, gain=1, auto-degat=1]
        		Popularite[nom=Carte1, gain=1, auto-degat=1]
        		)]""";
        assertEquals(expResult, joueurMainPleine.toString());
    }
    
    	
    @Test
    void testPrendreCarte() {
        joueurMainVide.prendreCarte(attaque1);
        assertTrue(joueurMainVide.getMainJoueur().getCartes().contains(attaque1));
    }
    
    
    @Test
    void testPeutAttaquerTrue() {
        assertTrue(joueurMainVide.peutAttaquer(attaque1));
    }
    
    
    @Test
    void testPeutAttaquerFalse() {
    	joueurMainVide.getCarteProtegeJoueur().add(attaque1);
        assertFalse(joueurMainVide.peutAttaquer(attaque1));
    }
    
    
    @Test
    void testCarteHasard() {
    	int tailleAvant = joueurMainPleine.getMainJoueur().getCartes().size();
        Carte c = joueurMainPleine.carteHasard(joueurMainPleine.getMainJoueur().getCartes().size());
        assertNotNull(c);
        assertEquals(tailleAvant - 1, joueurMainPleine.getMainJoueur().getCartes().size());
    }
    
    
    @Test
    void testMainJoueurJouerCarteExistante() {
    	for (int i = 0; i<4; i++)
    	joueurMainPleine.getMainJoueur().jouerCarte(popularite1);
        assertFalse(joueurMainPleine.getMainJoueur().getCartes().contains(popularite1));
    }

    @Test
    void testMainJoueurJouerCarteInexistante() {
        joueurMainVide.getMainJoueur().jouerCarte(popularite1);
        assertTrue(joueurMainPleine.getMainJoueur().getCartes().contains(popularite1));
    }
    
}
