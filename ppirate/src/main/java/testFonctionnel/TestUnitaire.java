/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testFonctionnel;

import java.util.List;
import model.Pioche;
import model.cartes.Carte;

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
    
    public static void main(String[] args) {
        System.out.println("*************************************************");
        TestUnitaire.testPiocher();
        System.out.println("*************************************************");
        TestUnitaire.testTrierPioche();
        System.out.println("*************************************************");
        TestUnitaire.testDistribuer();
        System.out.println("*************************************************");
    }
}
