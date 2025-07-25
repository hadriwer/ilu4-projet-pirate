package scenarioDeTest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyaufonctionnel.entity.DictionnaireCarte;
import noyaufonctionnel.entity.Jeu;
import noyaufonctionnel.entity.Joueur;
import noyaufonctionnel.entity.Pioche;
import noyaufonctionnel.entity.cartes.Attaque;
import noyaufonctionnel.entity.cartes.Carte;
import noyaufonctionnel.entity.cartes.GainVie;
import noyaufonctionnel.entity.cartes.Popularite;

class ScenarioDeTests {

	private Jeu jeu;
	private Pioche pioche;
	private Attaque carteAttaque;
	private Popularite cartePopularite;
	private GainVie carteGainVie;
	private DictionnaireCarte dictCarte;

	private Joueur j1;
	private Joueur j2;

	@BeforeEach
	public void setUp() {
		carteAttaque = new Attaque(1, "Attaque", "desc", 2, 1);
		cartePopularite = new Popularite(2, "Popularite", "desc", 2, 1);
		carteGainVie = new GainVie(4, "GainVie", "desc", 2);

		dictCarte = new DictionnaireCarte();

		pioche = new Pioche(dictCarte);

		jeu = new Jeu(pioche);

		jeu.setJoueur1Nom("Jack");
		jeu.setJoueur2Nom("Paul");

		j1 = jeu.getJoueur1();
		j2 = jeu.getJoueur2();

	}

	@Test
	void attaqueSimple() {
		carteAttaque.apply(j1, j2);
		assertEquals(4, j1.getIndiceVie());
		assertEquals(3, j2.getIndiceVie());
	}

	@Test
	void attaqueSansEffet() {
		Attaque atk = new Attaque(1, "vide", "rien", 0, 0);
		atk.apply(j1, j2);
		assertEquals(5, j1.getIndiceVie());
		assertEquals(5, j2.getIndiceVie());
	}

	@Test
	void attaqueSousProtection() {
		j2.getCarteProtegeJoueur().add(carteAttaque);
		carteAttaque.apply(j1, j2);
		assertFalse(j2.peutAttaquer(carteAttaque));
		assertEquals(5, j1.getIndiceVie());
		assertEquals(5, j2.getIndiceVie());
	}

	@Test
	void attaqueDepassantZero() {
		j2.perdreVie(4);
		carteAttaque.apply(j1, j2);
		assertEquals(0, j2.getIndiceVie());
	}

	@Test
	void victoireJ1AttaqueDeJ1SurJ2() {
		j2.perdreVie(3);
		carteAttaque.apply(j1, j2);
		assertTrue(jeu.verifierFinPartie());
		assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
		assertTrue(j2.aPerdu());
	}

	@Test
	void victoireJ2AttaqueDeJ1SurJ2() {
		j1.perdreVie(4);
		carteAttaque.apply(j1, j2);
		assertTrue(jeu.verifierFinPartie());
		assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
		assertTrue(j1.aPerdu());
	}

	@Test
	void populariteSimple() {
		cartePopularite.apply(j1, j2);
		assertEquals(4, j1.getIndiceVie());
		assertEquals(2, j1.getIndicePopularite());
	}

	@Test
	void populariteSansEffet() {
		Popularite pop = new Popularite(1, "vide", "rien", 0, 0);
		pop.apply(j1, j2);
		assertEquals(5, j1.getIndiceVie());
		assertEquals(0, j1.getIndicePopularite());
	}

	@Test
	void populariteDepassant5() {
		j1.gagnerPop(4);
		cartePopularite.apply(j1, j2);
		assertEquals(5, j1.getIndicePopularite());
	}

	@Test
	void victoireJ1GainPop() {
		j1.gagnerPop(3);
		cartePopularite.apply(j1, j2);
		assertTrue(jeu.verifierFinPartie());
		assertEquals("Jack", jeu.giveJoueurGagnant().getNom());
		assertTrue(j1.aGagne());
	}

	@Test
	void victoireJ2SuicideDeJ1AvecPop() {
		j1.perdreVie(4);
		cartePopularite.apply(j1, j2);
		assertTrue(jeu.verifierFinPartie());
		assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
		assertTrue(j1.aPerdu());
	}

	@Test
	void echangeCarte() {
		// code de setEffet de la carte echange pour récuperer les cartes
		Carte c1 = j1.carteHasard(j1.getMainJoueur().getCartes().size());
		Carte c2 = j2.carteHasard(j1.getMainJoueur().getCartes().size());

		j1.getMainJoueur().prendreCarte(c2);
		j2.getMainJoueur().prendreCarte(c1);

		// On verifie que l'echange a ete fait
		assertTrue(j1.getMainJoueur().getCartes().contains(c2));
		assertTrue(j2.getMainJoueur().getCartes().contains(c1));
	}

	@Test
	void initialisationJeu() {
		assertEquals(4, jeu.getJoueur1().getMainJoueur().getCartes().size());
		assertEquals(4, jeu.getJoueur2().getMainJoueur().getCartes().size());
		assertTrue(jeu.getZoneAction().isEmpty());
		assertTrue(jeu.getZonePopulariteJ1().isEmpty());
		assertTrue(jeu.getZonePopulariteJ2().isEmpty());
	}

	@Test
	void changerJoueur() {
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
	void deposerCarteAction() {
		jeu.deposerCarte(carteAttaque);

		assertTrue(jeu.getZoneAction().contains(carteAttaque));
	}

	@Test
	void deposerCartePopulariteJ1() {
		jeu.deposerCarte(cartePopularite);

		assertTrue(jeu.getZonePopulariteJ1().contains(cartePopularite));
	}

	@Test
	void ajouterEtRetirerCarteMain() {
		Joueur jCourant = jeu.getTourDeJeu() ? jeu.getJoueur1() : jeu.getJoueur2();
		jeu.joueurPrendreCarte(carteAttaque);
		assertTrue(jCourant.getMainJoueur().getCartes().contains(carteAttaque));

		jeu.removeCarteMainJoueur(carteAttaque);
		assertFalse(jCourant.getMainJoueur().getCartes().contains(carteAttaque));
	}

	@Test
	void initialisationJoueur() {
		assertEquals(5, j1.getIndiceVie());
		assertEquals(0, j1.getIndicePopularite());
		assertEquals(4, j1.getMainJoueur().getCartes().size());
		assertEquals("Jack", jeu.getJoueur1Nom());
		assertEquals("Paul", jeu.getJoueur2Nom());

	}

	@Test
	void gainVieSurJ1Simple() {
		j1.perdreVie(3);
		carteGainVie.apply(j1, j2);

		assertEquals(4, j1.getIndiceVie());
	}

	@Test
	void gainVieSurJ1Depassant5() {
		j1.perdreVie(1);
		carteGainVie.apply(j1, j2);

		assertEquals(5, j1.getIndiceVie());
	}
	
	@Test
	void partieComplete() {
	    // Initialisation
	    assertFalse(jeu.verifierFinPartie());
	    assertEquals("Jack", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());

	    // Tour 1 : Jack joue une carte de popularit�
	    jeu.deposerCarte(cartePopularite);
	    cartePopularite.apply(j1, j2); // Jack joue Popularit� (gain 2, perte 1)
	    assertEquals(2, j1.getIndicePopularite());
	    assertEquals(4, j1.getIndiceVie());

	    // Changement de joueur : Paul
	    jeu.changerJoueur();
	    assertEquals("Paul", jeu.getTourDeJeu() ? jeu.getJoueur1Nom() : jeu.getJoueur2Nom());

	    // Paul joue une attaque sur Jack
	    jeu.deposerCarte(carteAttaque);
	    carteAttaque.apply(j2, j1); // Paul attaque Jack (Jack perd 2, Paul perd 1)
	    assertEquals(2, j1.getIndiceVie());
	    assertEquals(4, j2.getIndiceVie());

	    // Changement de joueur : Jack
	    jeu.changerJoueur();

	    // Jack joue encore une carte de popularit�
	    jeu.deposerCarte(cartePopularite);
	    cartePopularite.apply(j1, j2); // gain 2 pop, perte 1 vie
	    assertEquals(4, j1.getIndicePopularite());
	    assertEquals(1, j1.getIndiceVie());

	    // Changement de joueur : Paul
	    jeu.changerJoueur();

	    // Paul rejoue une attaque sur Jack
	    jeu.deposerCarte(carteAttaque);
	    carteAttaque.apply(j2, j1); // Jack meurt

	    // V�rification fin de partie
	    assertTrue(jeu.verifierFinPartie());
	    assertEquals("Paul", jeu.giveJoueurGagnant().getNom());
	    assertTrue(j1.aPerdu());
	    assertFalse(j2.aPerdu());
	}
}
