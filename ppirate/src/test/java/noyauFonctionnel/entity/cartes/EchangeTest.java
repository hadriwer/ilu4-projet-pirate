package noyauFonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.Joueur;
import util.EnumCarte;

class EchangeTest {

	private Echange carteEchange;
	private Joueur j1;
	private Joueur j2;
	
    @BeforeEach
    public void setUp() {
    	carteEchange = new Echange(1, "Echange", "desc");
        
        ArrayList<Carte> main1 = new ArrayList<>();
        for (int i = 0; i<4; i++)
        main1.add(new Attaque(1, "AttaqueJ1", "desc", 2, 0));
       
        ArrayList<Carte> main2 = new ArrayList<>();
        for (int i = 0; i<4; i++)
        main2.add(new Attaque(2, "AttaqueJ2", "desc", 1, 0));

        j1 = new Joueur(main1);
        j2 = new Joueur(main2);
    }
    
    
    @Test
    public void testToString() {
        String attendu = "Echange[nom=Echange]";
        assertEquals(attendu, carteEchange.toString());
    }
    
    
    @Test
    public void testHashCode() {
        Echange memeEchange = new Echange(2, "Echange", "desc");
        assertEquals(carteEchange.hashCode(), memeEchange.hashCode());
    }
    
    
    @Test
    public void testClone() {
    	Echange copie = carteEchange.clone();
        assertEquals(carteEchange, copie);
        assertNotSame(carteEchange, copie);
    }

    @Test
    public void testGetType() {
        assertEquals(EnumCarte.ECHANGE, carteEchange.getType());
    }

    
    @Test
    public void testSetEffet() {
        carteEchange.apply(j1, j2);

    }
}
