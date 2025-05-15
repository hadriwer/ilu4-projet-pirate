/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.controller;

import noyauFonctionnel.entity.DictionnaireCarte;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.GainVie;
import noyauFonctionnel.entity.cartes.Popularite;
import noyauFonctionnel.entity.cartes.Protection;
import util.EnumCarte;

/**
 *
 * @author Solène
 */
public class ControlCarte {
	
	private static final String ERREUR_IDCARTE_INVALIDE = "idCarte invalide";
   
    private final DictionnaireCarte dictionnaireCarte;
    
    public ControlCarte(DictionnaireCarte dictionnaireCarte){
        this.dictionnaireCarte=dictionnaireCarte;
        
    }
    
    public EnumCarte getType(int idCarte){
        return dictionnaireCarte.getCarte(idCarte).getType();
    }
    
    public String getNomAttaqueBloque(int idCarte) {
        return ((Protection) dictionnaireCarte.getCarte(idCarte)).getNomAttaqueBloque();
    }
    
    public String getNom(int idCarte){
        return dictionnaireCarte.getCarte(idCarte).getNom();
    }
    public String getDescription(int idCarte){
        return dictionnaireCarte.getCarte(idCarte).getDescription();
    }
    public int getPointPopularite(int idCarte){
        if (dictionnaireCarte.getCarte(idCarte).getType() == EnumCarte.POPULARITE){
            return ((Popularite) dictionnaireCarte.getCarte(idCarte)).getPointDePop();
        }else{
            throw new IllegalArgumentException(ERREUR_IDCARTE_INVALIDE);
        }
    }
    public int getSelfDegat(int idCarte){
        if (dictionnaireCarte.getCarte(idCarte).getType() == EnumCarte.POPULARITE){
            return ((Popularite) dictionnaireCarte.getCarte(idCarte)).getSelfDegats();
        }
        if (dictionnaireCarte.getCarte(idCarte).getType() == EnumCarte.ATTAQUE){
            return ((Attaque) dictionnaireCarte.getCarte(idCarte)).getSelfDegats();
        }
            throw new IllegalArgumentException(ERREUR_IDCARTE_INVALIDE);
    }
    public int getActionVie(int idCarte){
        if (dictionnaireCarte.getCarte(idCarte).getType() == EnumCarte.ATTAQUE){
            return ((Attaque) dictionnaireCarte.getCarte(idCarte)).getActionVie();
        }else{
            throw new IllegalArgumentException(ERREUR_IDCARTE_INVALIDE);
        }            
    }
    
    public int getGainVie(int idCarte) {
        if (dictionnaireCarte.getCarte(idCarte).getType() == EnumCarte.GAIN_VIE) {
            return ((GainVie) dictionnaireCarte.getCarte(idCarte)).getGainVie();
        }else{
            throw new IllegalArgumentException(ERREUR_IDCARTE_INVALIDE);
        }
    }
    
}
