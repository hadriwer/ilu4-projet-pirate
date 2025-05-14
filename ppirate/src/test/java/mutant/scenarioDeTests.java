package mutant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.DictionnaireCarte;
import noyauFonctionnel.entity.Jeu;
import noyauFonctionnel.entity.Joueur;
import noyauFonctionnel.entity.Pioche;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
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
        cartePopularite = new Popularite(2,"Popularite", "desc", 2, 1);
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
        assertFalse(j2.peutAttaquer(carteAttaque));
        assertEquals(5, j1.getIndiceVie());
        assertEquals(5, j2.getIndiceVie());
    }
	
	
	@Test
	public void attaqueDepassantZero() {
		j2.perdreVie(4);
		carteAttaque.apply(j1, j2);
		assertEquals(0, j2.getIndiceVie());
	}
	
	@Test 
	public void victoireJ1AttaqueDeJ1SurJ2() {
		j2.perdreVie(3);
		carteAttaque.apply(j1, j2);
        assertTrue(jeu.verifierFinPartie());
        assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
        assertTrue(j2.aPerdu()); 
    }
	
	
	@Test
	public void victoireJ2AttaqueDeJ1SurJ2() {
		j1.perdreVie(4);
		carteAttaque.apply(j1, j2);
        assertTrue(jeu.verifierFinPartie());
        assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
        assertTrue(j1.aPerdu()); 
    }
	
	
	@Test
	public void populariteSimple() {
		cartePopularite.apply(j1, j2);
        assertEquals(4, j1.getIndiceVie());
        assertEquals(2, j1.getIndicePopularite());
	}
	
	
	@Test 
	public void populariteSansEffet() {
        Popularite pop = new Popularite(1, "vide", "rien", 0, 0);
        pop.apply(j1, j2);
        assertEquals(5, j1.getIndiceVie());
        assertEquals(0, j1.getIndicePopularite());
    }
	
	
	@Test
	public void populariteDepassant5() {
		j1.gagnerPop(4);
		cartePopularite.apply(j1, j2);
		assertEquals(5, j1.getIndicePopularite());
	}
	
	@Test 
	public void victoireJ1GainPop() {
		j1.gagnerPop(3);
		cartePopularite.apply(j1, j2);
        assertTrue(jeu.verifierFinPartie());
        assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
        assertTrue(j1.aGagne()); 
    }
	
	
	@Test
	public void victoireJ2SuicideDeJ1AvecPop() {
		j1.perdreVie(4);
		cartePopularite.apply(j1, j2);
        assertTrue(jeu.verifierFinPartie());
        assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
        assertTrue(j1.aPerdu()); 
    }
	
	
	@Test
	public void echangeCarte() {
		// code de setEffet de la carte echange pour récuperer les cartes
		Carte c1 = j1.carteHasard(); 
        Carte c2 = j2.carteHasard(); 
         
        j1.getMainJoueur().prendreCarte(c2);
        j2.getMainJoueur().prendreCarte(c1);
        
        // On verifie que l'echange a ete fait
        assertTrue(j1.getMainJoueur().getCartes().contains(c2));
        assertTrue(j2.getMainJoueur().getCartes().contains(c1));
	}
	
	
	@Test
	public void initialisationJeu() {
	    assertEquals(4, jeu.getJoueur1().getMainJoueur().getCartes().size());
	    assertEquals(4, jeu.getJoueur2().getMainJoueur().getCartes().size());
	    assertTrue(jeu.getZoneAction().isEmpty());
	    assertTrue(jeu.getZonePopulariteJ1().isEmpty());
	    assertTrue(jeu.getZonePopulariteJ2().isEmpty());
	}
	
	
	@Test
	public void changerJoueur() {
		// Avant changement
	    boolean tourInitial = jeu.getTourDeJeu();
	    assertEquals("Jack", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());
	    assertEquals(tourInitial, jeu.getTourDeJeu());
	    
	    // Après changement 
	    jeu.changerJoueur();
	    assertEquals("Paul", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());
	    assertNotEquals(tourInitial, jeu.getTourDeJeu());
	}
	
	
	@Test
	public void deposerCarteAction() {
	    jeu.deposerCarte(carteAttaque);

	    assertTrue(jeu.getZoneAction().contains(carteAttaque));
	}
	
	
	@Test
	public void deposerCartePopulariteJ1() {
	    jeu.deposerCarte(cartePopularite);

	    assertTrue(jeu.getZonePopulariteJ1().contains(cartePopularite));
	}
	
	
	@Test
	void ajouterEtRetirerCarteMain() {
		Joueur jCourant =  jeu.getTourDeJeu() ? jeu.getJoueur1() : jeu.getJoueur2();
	    jeu.joueurPrendreCarte(carteAttaque);
	    assertTrue(jCourant.getMainJoueur().getCartes().contains(carteAttaque));

	    jeu.removeCarteMainJoueur(carteAttaque);
	    assertFalse(jCourant.getMainJoueur().getCartes().contains(carteAttaque));
	}


	@Test
	public void initialisationJoueur() {
	    assertEquals(5, j1.getIndiceVie());
	    assertEquals(0, j1.getIndicePopularite());
	    assertEquals(4, j1.getMainJoueur().getCartes().size());
    	assertEquals("Jack", jeu.getJoueur1Nom());
    	assertEquals("Paul", jeu.getJoueur2Nom());

	}
	
	
	@Test
	public void gainVieSurJ1Simple() {
		j1.perdreVie(3);
		carteGainVie.apply(j1, j2);
		
		assertEquals(4, j1.getIndiceVie());
	}
	
	@Test
	public void gainVieSurJ1Depassant5() {
		j1.perdreVie(1);
		carteGainVie.apply(j1, j2);
		
		assertEquals(5, j1.getIndiceVie());
	}
}
