package noyauFonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.Joueur;
import util.EnumCarte;

class GainVieTest {

	private GainVie carteGainVie;
    private Joueur j1;
    private Joueur j2;

    @BeforeEach
    public void setUp() {
        carteGainVie = new GainVie(5, "Potion", "Rend 2 PV", 2);
        j1 = new Joueur(new ArrayList<>());
        j2 = new Joueur(new ArrayList<>());
    }

    @Test
    public void testGetGainVie() {
        assertEquals(2, carteGainVie.getGainVie());
    }

    @Test
    public void testGetType() {
        assertEquals(EnumCarte.GAIN_VIE, carteGainVie.getType());
    }

    @Test
    public void testClone() {
        Carte copie = carteGainVie.copie();
        assertEquals(carteGainVie, copie);
        assertNotSame(carteGainVie, copie);
    }

    @Test
    public void testApplyEffetGainVie() {
        j1.perdreVie(3);  
        carteGainVie.apply(j1, j2); 
        assertEquals(4, j1.getIndiceVie()); 
        assertEquals(5, j2.getIndiceVie()); 
    }

}
