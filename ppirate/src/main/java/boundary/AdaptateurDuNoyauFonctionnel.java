/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.List;
import noyauFonctionnel.controller.*;
import noyauFonctionnel.entity.cartes.*;

/**
 *
 * @author wer
 */
public class AdaptateurDuNoyauFonctionnel {

    public List<Carte> getZoneAction(ControlJeu controlJeu) {
        return controlJeu.getZoneAction();
    }
}