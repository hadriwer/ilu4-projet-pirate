package noyauFonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.Joueur;
import util.EnumCarte;

class ProtectionTest {
    private Protection carteProtection;
    private Attaque carteAttaque;
    private Joueur j1;
    private Joueur j2;
    

    @BeforeEach
    public void setUp() {
    	carteAttaque = new Attaque(1, "Attaque", "desc", 2, 0);
        carteProtection = new Protection(2, "Protection", "desc", carteAttaque);
        
        j1 = new Joueur(new ArrayList<>());
        j2 = new Joueur(new ArrayList<>());
    }

    @Test
    public void testGetNomAttaqueBloque() {
        assertEquals("Attaque", carteProtection.getNomAttaqueBloque());
    }

    @Test
    public void testToString() {
        String attendu = "Protection[nom=Protection, attaque bloquée=Attaque]";
        assertEquals(attendu, carteProtection.toString());
    }
    
    
    @Test
    public void testBloqueTrue() {
        assertTrue(carteProtection.bloque(carteAttaque));
    }

    @Test
    public void testBloqueFalse() {
        assertFalse(carteProtection.bloque(new Attaque(1, "autreAttaque", "desc", 2, 0)));
    }
    
    
    @Test
    public void testHashCode() {
        Protection memeProtection = new Protection(2, "Protection", "desc", carteAttaque);
        assertEquals(carteProtection.hashCode(), memeProtection.hashCode());
    }
    
    
    @Test
    public void testClone() {
    	Protection copie = carteProtection.copie();
        assertEquals(carteProtection, copie);
        assertNotSame(carteProtection, copie);
    }
    
    
    
    @Test
    public void testGetType() {
        assertEquals(EnumCarte.PROTECTION, carteProtection.getType());
    }

    
    @Test
    public void testEffetApplique() {
        
    	assertTrue(j1.getCarteProtegeJoueur().isEmpty());

        carteProtection.apply(j1, j2);

        assertEquals(1, j1.getCarteProtegeJoueur().size());
        assertTrue(j1.getCarteProtegeJoueur().contains(carteAttaque)); 
    }


}
