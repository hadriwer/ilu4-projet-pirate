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
    void testGetNom() {
        assertEquals("carte", carte.getNom());
    }

    @Test
    void testGetDescription() {
        assertEquals("desc", carte.getDescription());
    }

    @Test
    void testSetId() {
        carte.setId(10);
        assertEquals(10, carte.getId());
    }

    @Test
    void testEqualsTrue() {
    	// cas même référence
    	assertEquals(carte, carte);
    	
    	// cas même attributs
        Carte memeCarte = new CarteTestImpl(1, "carte", "desc");
        assertEquals(carte, memeCarte);
    }
    
    
    @Test
    void testEqualsFalse() {
    	// cas object null
    	assertNotEquals(null, carte);
    	
    	// cas pas une carte
    	assertNotEquals("Pas une carte", carte);
    	
    	// cas nom différent
        Carte carteDiff1 = new CarteTestImpl(1, "carteDiff1", "desc");
        assertNotEquals(carte, carteDiff1);
        
        // cas description différent
        Carte carteDiff2 = new CarteTestImpl(1, "carte", "desc2");
        assertNotEquals(carte, carteDiff2);
    }

    
    @Test
    void testHashCode() {
    	Carte memeCarte = new CarteTestImpl(1, "carte", "desc");
        assertEquals(carte.hashCode(), memeCarte.hashCode());
    }


    @Test
    void testSetEffetEtApply() {
        
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
