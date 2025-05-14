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
public class JoueurTest {
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
    public void testGetNom() {
        assertEquals("Jack", joueurMainVide.getNom());
    }
    
    
    @Test
    public void testSetNom() {
    	joueurMainVide.setNom("Dave");
    	assertEquals("Dave", joueurMainVide.getNom());
    }
    
    
    @Test
    public void testGetIndicePopularite() {
        assertEquals(0, joueurMainVide.getIndicePopularite());
    }

    
    @Test
    public void testGetIndiceVieInitial() {
        assertEquals(5, joueurMainVide.getIndiceVie());
    }
    
    
    // test de la perte de vie dans le cas normal sans dépasser 0 
    @Test
    public void testPerdreVie() {
        joueurMainVide.perdreVie(1);
        assertEquals(4, joueurMainVide.getIndiceVie());
    }
    
    // test de la perte de vie dans le cas normal en dépassant 0 
    @Test
    public void testPerdreVieDepassement() {
    	joueurMainVide.perdreVie(6);
        assertEquals(0, joueurMainVide.getIndiceVie());
    }
    
    
    // test du gain de vie dans le cas normal sans dépasser 5 
    @Test
    public void testGagnerVie() {
    	joueurMainVide.perdreVie(2);
        joueurMainVide.gagnerVie(1);
        assertEquals(4, joueurMainVide.getIndiceVie());
    }
    
    // test du gain de vie dans le cas normal en dépassant 5 
    @Test
    public void testGagnerVieDepassement() {
    	joueurMainVide.perdreVie(1);
        joueurMainVide.gagnerVie(2);
        assertEquals(5, joueurMainVide.getIndiceVie());
    }

    
    @Test
    public void testGagnerPop() {
    	joueurMainVide.gagnerPop(1);
        assertEquals(1, joueurMainVide.getIndicePopularite());
    }
    
   
    @Test
    public void testGagnerPopDepassement() {
    	joueurMainVide.gagnerPop(6);
        assertEquals(5, joueurMainVide.getIndicePopularite());
    }

    
    @Test
    public void testAGagneFalse() {
        assertFalse(joueurMainVide.aGagne());
    }
    
    
    @Test
    public void testAGagneTrue() {
    	joueurMainVide.gagnerPop(5);
    	assertTrue(joueurMainVide.aGagne()); 
    }

    
    @Test
    public void testAPerduFalse() {
    	assertFalse(joueurMainVide.aPerdu());
    }
    
    
    @Test
    public void testAPerduTrue() {
    	joueurMainVide.perdreVie(5);
    	assertTrue(joueurMainVide.aPerdu()); 
    }

    
    @Test
    public void testToStringMainVide() {
        String expResult = "Joueur[nom=Jack, vie=5, popularite=0, contenu de la main= vide]";
        assertEquals(expResult, joueurMainVide.toString());
    }
    
    
    @Test
    public void testToStringMainPleine() {
        String expResult = "Joueur[nom=Paul, vie=5, popularite=0, contenu de la main=(\n"
        		+ "Popularite[nom=Carte1, gain=1, auto-degat=1]\n"
        		+ "Popularite[nom=Carte1, gain=1, auto-degat=1]\n"
        		+ "Popularite[nom=Carte1, gain=1, auto-degat=1]\n"
        		+ "Popularite[nom=Carte1, gain=1, auto-degat=1]\n"
        		+ ")]";
        assertEquals(expResult, joueurMainPleine.toString());
    }
    
    	
    @Test
    public void testPrendreCarte() {
        joueurMainVide.prendreCarte(attaque1);
        assertTrue(joueurMainVide.getMainJoueur().getCartes().contains(attaque1));
    }
    
    
    @Test
    public void testPeutAttaquerTrue() {
        assertTrue(joueurMainVide.peutAttaquer(attaque1));
    }
    
    
    @Test
    public void testPeutAttaquerFalse() {
    	joueurMainVide.getCarteProtegeJoueur().add(attaque1);
        assertFalse(joueurMainVide.peutAttaquer(attaque1));
    }
    
    
    @Test
    public void testCarteHasard() {
    	int tailleAvant = joueurMainPleine.getMainJoueur().getCartes().size();
        Carte c = joueurMainPleine.carteHasard(joueurMainPleine.getMainJoueur().getCartes().size());
        assertNotNull(c);
        assertEquals(tailleAvant - 1, joueurMainPleine.getMainJoueur().getCartes().size());
    }
    
    
    @Test
    public void testMainJoueurJouerCarteExistante() {
    	for (int i = 0; i<4; i++)
    	joueurMainPleine.getMainJoueur().jouerCarte(popularite1);
        assertFalse(joueurMainPleine.getMainJoueur().getCartes().contains(popularite1));
    }

    @Test
    public void testMainJoueurJouerCarteInexistante() {
        joueurMainVide.getMainJoueur().jouerCarte(popularite1);
        assertTrue(joueurMainPleine.getMainJoueur().getCartes().contains(popularite1));
    }
    
}
