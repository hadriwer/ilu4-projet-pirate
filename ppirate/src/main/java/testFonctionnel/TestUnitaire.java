/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testFonctionnel;

import java.util.List;
import noyauFonctionnel.entity.Pioche;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.Popularite;

/**
 *
 * @author wer
 */
public class TestUnitaire {
    
    private static void testPiocher() {
        Pioche p = new Pioche();
        System.out.println(p.getPioche());
        System.out.println(p.piocher());
        System.out.println(p.getPioche());
    }
    
    private static void testTrierPioche() {
        Pioche p = new Pioche();
        System.out.println("List aléatoire : " + p.getPioche()); // La liste quand elle est crée dans init elle est automatiquement triée
    }
    
    private static void testDistribuer() {
        Pioche p = new Pioche();
        System.out.println("état de la pioche avant : " + p.getPioche());
        System.out.println("Taille de la liste avant = " + p.getPioche().size());
        List<Carte> mainJoueur1 = p.distribuer(2);
        System.out.println("Carte distribuée " + mainJoueur1);
        System.out.println("état de la pioche après : " + p.getPioche());
        System.out.println("Taille de la liste après distribuer = " + p.getPioche().size());
    }
    
    private static void testEqualsCarte() {
        Carte c1 = new Attaque("Sabotage", "tqt", 2);
        Carte c2 = new Attaque("Sabotage", "hahahahha", 2);
        Carte c3 = new Popularite("Fierté", "tqt", 1);
        Carte c4 = new Popularite("Fierté", "une autre description", 1);
        System.out.println("c1 == c1 ? : " + c1.equals(c1));
        System.out.println("c1 == c2 ? : " + c1.equals(c2));
        System.out.println("c2 == c3 ? : " + c2.equals(c3));
        System.out.println("c3 == c4 ? : " + c3.equals(c4));
    }
    
    public static void main(String[] args) {
        System.out.println("*************************************************");
        TestUnitaire.testPiocher();
        System.out.println("*************************************************");
        TestUnitaire.testTrierPioche();
        System.out.println("*************************************************");
        TestUnitaire.testDistribuer();
        System.out.println("*************************************************");
        TestUnitaire.testEqualsCarte();
    }
}
