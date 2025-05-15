/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import noyauFonctionnel.entity.Joueur;

/**
 *
 * @author wer
 */
@FunctionalInterface
public interface IEffetCarte {
    void apply(Joueur self, Joueur cible);
}
