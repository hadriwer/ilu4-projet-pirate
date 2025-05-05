/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import java.util.Objects;

/**
 *
 * @author Solène
 */
public class Protection extends Carte{
    
    public Protection(String nom, String description) {
        super(nom, description);
    }
    
    @Override
    public String toString() {
        return "Protection[nom=" + this.getNom() + "";
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
    
}
