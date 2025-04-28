package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private Joueur instanceMainVide;
    private Joueur instanceMainNonVide;
    private Carte carteTest1;
    private Carte carteTest2;

    @BeforeEach
    void setUp() {
        // Cartes et joueur de tests
        carteTest1 = new Popularite("Carte1", "desc1", 1, 1);
        carteTest2 = new Popularite("Carte2", "desc2", 0, 0);
        List<Carte> cartes = new ArrayList<>();
        cartes.add(carteTest1);
        instanceMainNonVide = new Joueur("Jack", cartes);
        instanceMainVide = new Joueur("Jack", new ArrayList<>());
    }
    
    /**
     * Test méthode getIndicePopularite, de la classe Joueur.
     */
    @Test
    public void testGetIndicePopulariteInitial() {
        int expResult = 0;
        int result = instanceMainVide.getIndicePopularite();
        assertEquals(expResult, result);
    }

    /**
     * Test méthode getIndiceVie, de la classe Joueur.
     */
    @Test
    public void testGetIndiceVieInitial() {
        int expResult = 5;
        int result = instanceMainVide.getIndiceVie();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode getNom, de la classe Joueur.
     */
    @Test
    public void testGetNom() {
        String expResult = "Jack";
        String result = instanceMainVide.getNom();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode perdreVie dans le cas normal, de la classe Joueur.
     */
    @Test
    public void testPerdreVie() {
        instanceMainVide.perdreVie(1);
        
        int expResult = 4;
        int result = instanceMainVide.getIndiceVie();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode perdreVie dans le cas où on en perds plus que le nombre max, de la classe Joueur.
     */
    @Test
    public void testPerdreViePlusDeIndiceVieInitialFois() {
        for (int i = 0; i < Joueur.MAXVIE + 1; i++) { // + 1 : tester une perte de vie une fois de plus pour tester si ca reste à 0
            instanceMainVide.perdreVie(1);
        }
        int expResult = 0;
        int result = instanceMainVide.getIndiceVie();
        assertEquals(expResult, result);
    }

    /**
     * Test méthode gagnerPop dans le cas normal, de la classe Joueur.
     */
    @Test
    public void testGagnerPop() {
        instanceMainVide.gagnerPop(1);
        int expResult = 1;
        int result = instanceMainVide.getIndicePopularite();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode gagnerPop dans le cas où on en gagne plus que le nombre max, de la classe Joueur.
     */
    @Test
    public void testGagnerPopPlusDeIndicePopulariteMaxFois() {
        for (int i = 0; i < Joueur.MAXPOP + 1 ; i++) {
            instanceMainVide.gagnerPop(1);
        }
        int expResult = 5;
        int result = instanceMainVide.getIndicePopularite();
        assertEquals(expResult, result);
    }

    /**
     * Test méthode aGagne dans le cas False, de la classe Joueur.
     */
    @Test
    public void testAGagneFalse() {
        boolean expResult = false;
        boolean result = instanceMainVide.aGagne();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode aGagne dans le cas True, de la classe Joueur.
     */
    @Test
    public void testAGagneTrue() {
        while (instanceMainVide.getIndicePopularite() < 5) {
            instanceMainVide.gagnerPop(1);
        }
        boolean expResult = true;
        boolean result = instanceMainVide.aGagne();
        assertEquals(expResult, result);
    }

    /**
     * Test méthode aPerdu dans le cas False, de la classe Joueur.
     */
    @Test
    public void testAPerduFalse() {
        boolean expResult = false;
        boolean result = instanceMainVide.aPerdu();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode aPerdu dans le cas True, de la classe Joueur.
     */
    @Test
    public void testAPerduTrue() {
        while (instanceMainVide.getIndiceVie() > 0) {
            instanceMainVide.perdreVie(1);
        }
        boolean expResult = true;
        boolean result = instanceMainVide.aPerdu();
        assertEquals(expResult, result);
    }

    /**
     * Test méthode toString dans le cas main vide, de la classe Joueur.
     */
    @Test
    public void testToStringMainVide() {
        String expResult = "Joueur[nom=Jack, vie=5, popularite=0, contenu de la main=Main vide]";
        String result = instanceMainVide.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode toString dans le cas main non vide, de la classe Joueur.
     */
    @Test
    public void testToStringMainNonVide() {
        String expResult = "Joueur[nom=Jack, vie=5, popularite=0, contenu de la main=Main[Popularite[nom=Carte1, gain=1, auto-degat=1] ]]";
        String result = instanceMainNonVide.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test méthode prendreCarte, de la classe Joueur.
     */
    @Test
    public void testPrendreCarte() {
        instanceMainVide.prendreCarte(carteTest2);
        assertTrue(instanceMainVide.getMainJoueur().getCartes().contains(new Popularite("Carte2", "desc2", 0, 0)));
    }
    
    /**
     * Test méthode getCartes dans le cas main vide, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurGetCartesAvecMainVide() {
        List<Carte> expResult = new ArrayList<>();
        List<Carte> result = instanceMainVide.getMainJoueur().getCartes();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode getCartes dans le cas main non vide, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurGetCartesAvecMainNonVide() {
        List<Carte> expResult = new ArrayList<>();
        expResult.add(new Popularite("Carte1", "desc1", 1, 1));
        List<Carte> result = instanceMainNonVide.getMainJoueur().getCartes();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode toString dans le cas main vide, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurToStringAvecMainVide() {
        String expResult = "Main vide";
        String result = instanceMainVide.getMainJoueur().toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode toString dans le cas main non vide, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurToStringAvecMainNonVide() {
        String expResult = "Main[Popularite[nom=Carte1, gain=1, auto-degat=1] ]";
        String result = instanceMainNonVide.getMainJoueur().toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode prendreCarte, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurPrendreCarte() {
        instanceMainVide.getMainJoueur().prendreCarte(carteTest2);
        assertTrue(instanceMainVide.getMainJoueur().getCartes().contains(new Popularite("Carte2", "desc2", 0, 0)));
    }
    
    /**
     * Test méthode jouerCarte dans le cas carte existante, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurJouerCarteCarteExistante() {
        instanceMainNonVide.getMainJoueur().jouerCarte(carteTest1);
        List<Carte> expResult = new ArrayList<>();
        List<Carte> result = instanceMainNonVide.getMainJoueur().getCartes();
        assertEquals(expResult, result);
    }
    
    /**
     * Test méthode jouerCarte dans le cas carte non existante, de la classe Joueur.MainJoueur.
     */
    @Test
    public void testGetMainJoueurJouerCarteCarteNonExistante() {
        instanceMainNonVide.getMainJoueur().jouerCarte(carteTest2);
        List<Carte> expResult = new ArrayList<>();
        expResult.add(carteTest1);
        List<Carte> result = instanceMainNonVide.getMainJoueur().getCartes();
        assertEquals(expResult, result);
    }
}
