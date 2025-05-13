package mutant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.DictionnaireCarte;
import noyauFonctionnel.entity.Jeu;
import noyauFonctionnel.entity.Joueur;
import noyauFonctionnel.entity.Pioche;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Echange;
import noyauFonctionnel.entity.cartes.GainVie;
import noyauFonctionnel.entity.cartes.Popularite;
import noyauFonctionnel.entity.cartes.Protection;

class scenarioDeTests {
	
	private Jeu jeu;
    private Pioche pioche;
    private Attaque carteAttaque;
    private Popularite cartePopularite;
    private Echange carteEchange;
    private GainVie carteGainVie;
    private Protection carteProtection;
    private DictionnaireCarte dictCarte;
    
    private Joueur j1;
    private Joueur j2;
    
	@BeforeEach
    public void setUp() {
        carteAttaque = new Attaque(1, "Attaque", "desc", 2, 1);
        cartePopularite = new Popularite(2,"Popularite", "desc", 1, 1);
        carteEchange = new Echange(3, "Echange", "desc");
        carteGainVie = new GainVie(4, "GainVie", "desc", 2);
        carteProtection = new Protection(5, "Protection", "desc", carteAttaque);

        dictCarte = new DictionnaireCarte();
        
        pioche = new Pioche(dictCarte);
     
        jeu = new Jeu(pioche);
        
        jeu.setJoueur1Nom("Jack");
        jeu.setJoueur2Nom("Paul");
        
        j1 = jeu.getJoueur1();
        j2 = jeu.getJoueur2();
    }
	
	
	@Test
	public void attaqueSimple() {
		carteAttaque.apply(j1, j2);
        assertEquals(4, j1.getIndiceVie());
        assertEquals(3, j2.getIndiceVie());
	}
	
	
	@Test 
	public void attaqueSansEffet() {
        Attaque atk = new Attaque(1, "vide", "rien", 0, 0);
        atk.apply(j1, j2);
        assertEquals(5, j1.getIndiceVie());
        assertEquals(5, j2.getIndiceVie());
    }
	
	
	@Test 
	public void attaqueSousProtection() {
        j2.getCarteProtegeJoueur().add(carteAttaque);
        carteAttaque.apply(j1, j2);
        assertEquals(5, j1.getIndiceVie());
        assertEquals(5, j2.getIndiceVie());
    }
	
	
	@Test 
	public void victoireJ1AttaqueDeJ1SurJ2() {
		j2.perdreVie(3);
		carteAttaque.apply(j1, j2);
        assertTrue(jeu.verifierFinPartie());
        assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
        assertTrue(j1.aGagne()); 
    }
	
	
	@Test
	public void victoireJ2AttaqueDeJ1SurJ2() {
		j1.perdreVie(4);
		carteAttaque.apply(j1, j2);
        assertTrue(jeu.verifierFinPartie());
        assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
        assertTrue(j2.aGagne()); 
    }
	
	
	@Test
	public void attaqueDepassantZero() {
		j2.perdreVie(4);
		carteAttaque.apply(j1, j2);
		assertEquals(0, j2.getIndiceVie());
	}
	
	
	
}
