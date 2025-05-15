package noyauFonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.Joueur;
import util.EnumCarte;

class CarteTest {

	private Carte carte;

    // Classe interne factice pour tester Carte car elle est abstraite
    private static class CarteTestImpl extends Carte {
        public CarteTestImpl(int id, String nom, String description) {
            super(id, nom, description);
        }

        @Override
        public EnumCarte getType() {
            return EnumCarte.ATTAQUE; 
        }

        @Override
        public Carte copie() {
            return new CarteTestImpl(this.id, this.nom, this.description);
        }
    }
    
    
    

    @BeforeEach
    public void setUp() {
    	carte = new CarteTestImpl(1, "carte", "desc");
    }
    
    
    @Test
    public void testGetNom() {
        assertEquals("carte", carte.getNom());
    }

    @Test
    public void testGetDescription() {
        assertEquals("desc", carte.getDescription());
    }

    @Test
    public void testSetId() {
        carte.setId(10);
        assertEquals(10, carte.getId());
    }

    @Test
    public void testEqualsTrue() {
    	// cas même référence
    	assertTrue(carte.equals(carte));
    	
    	// cas même attributs
        Carte memeCarte = new CarteTestImpl(1, "carte", "desc");
        assertTrue(carte.equals(memeCarte));
    }
    
    
    @Test
    public void testEqualsFalse() {
    	// cas object null
    	assertFalse(carte.equals(null));
    	
    	// cas pas une carte
    	assertFalse(carte.equals("Pas une carte"));
    	
    	// cas nom différent
        Carte carteDiff1 = new CarteTestImpl(1, "carteDiff1", "desc");
        assertFalse(carte.equals(carteDiff1));
        
        // cas description différent
        Carte carteDiff2 = new CarteTestImpl(1, "carte", "desc2");
        assertFalse(carte.equals(carteDiff2));
    }

    
    @Test
    public void testHashCode() {
    	Carte memeCarte = new CarteTestImpl(1, "carte", "desc");
        assertEquals(carte.hashCode(), memeCarte.hashCode());
    }


    @Test
    public void testSetEffetEtApply() {
        
    	Joueur j1 = new Joueur(new ArrayList<>());
    	Joueur j2 = new Joueur(new ArrayList<>());

        // Implémentation factice de EffetCarte
        IEffetCarte effetFictif = new IEffetCarte() {
            @Override
            public void apply(Joueur self, Joueur cible) {
                self.perdreVie(1);
                cible.perdreVie(2);
            }
        };
        
        carte.setEffet(effetFictif);
        
        carte.apply(j1, j2);

        assertEquals(4, j1.getIndiceVie()); 
        assertEquals(3, j2.getIndiceVie()); 
    }


}
