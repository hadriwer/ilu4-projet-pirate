package util;

import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.ConfigurationCarte;
import noyauFonctionnel.entity.cartes.Popularite;

/**
 *
 * @author ember
 */

public class CarteFactory {
    private CarteFactory() {
        throw new IllegalStateException("Utility class");
    }
    
    public static ConfigurationCarte[] creerCartes() {
        ConfigurationCarte[] cartes = new ConfigurationCarte[] {
            new ConfigurationCarte(new Popularite("Main de fer", 
                    "À la suite d'un bras de fer devant les membres d'équipage "
                            + "vous gagnez deux points de popularité, mais "
                            + "votre effort vous coûte un point de vie.", 2, 1), 4),
            new ConfigurationCarte(new Popularite("Abordage réussi", 
                    "Au cours d’un abordage, vous faites preuve d’une grande "
                            + "bravoure et gagnez deux points de popularité.", 2, 0), 4),
            new ConfigurationCarte(new Popularite("Discours inspirant", 
                    "Avant un abordage, vous inspirez vos troupes et gagnez "
                            + "ainsi un point de popularité.", 1, 0), 4),
            new ConfigurationCarte(new Popularite("Grande descente", 
                    "Suite à une beuverie avec l’équipage, vous prouvez votre "
                    +"supériorité et finissez victorieux, gagnant ainsi le" 
                            +"respect de vos matelots et deux points de popularité."
                            + "Malheureusement vous finissez la soirée avec le foie en compote"
                    +"et perdez deux points de vies.", 2, 2), 4),
            new ConfigurationCarte(new Popularite("Révolte simultanée", 
                    "Suite à une mutinerie, vous imposez votre autorité et "+
                            "restez capitaine, gagnant ainsi un point de popularité.", 1, 0), 4),
            new ConfigurationCarte(new Popularite("Butin inestimable", 
                    "Vous et votre équipage vous approchez d’une île en plein combat."+
                            " Contre les conseils de votre second et du maître d’équipage,"+
                            " vous décidez de prendre le risque et ordonnez à quelques hommes"
                            +" d’aller y déterrer un potentiel trésor. Votre instinct "
                            +"vous rapporte trois gros coffre bien remplis et "
                            +"trois points de popularité.", 3, 0), 4),
            new ConfigurationCarte(new Popularite("Vent en poupe", 
                    "De par votre expérience, vous ordonnez à l’équipage de changer"
                            +" de cap pour vous aider d’une rafale opportune. "
                            +"Vous gagnez en vitesse et remportez un point de popularité.", 1, 0), 4),
            
            new ConfigurationCarte(new Attaque("Bombe artisanale", 
                    "Vous avez fait exploser un baril de poudre proche de votre adversaire"
                            +" qui perd deux points de vie. Malheureusement vous"
                            +" étiez trop proche et perdez un point de vie. ", 2, 1), 4),
            new ConfigurationCarte(new Attaque("Coup de sabre", 
                    "Un coup de sabre parfaitement exécuté fais perdre deux point"
                            +" de vie à votre adversaire.", 2, 0), 4),
            new ConfigurationCarte(new Attaque("Abordage", 
                    "Vous dirigez un abordage contre votre adversaire et sortez victorieux,"
                            +" faisant perdre 2 point de vie à votre adversaire.", 2, 0), 4),
            new ConfigurationCarte(new Attaque("Bouteille cassée", 
                    "Vous vous armez d’une bouteille de rhum cassée et frappez"
                            +" votre adversaire sur la tête. Malheureusement"
                            +" son couvre-chef l’a protégé et il ne perd qu’un point de vie.", 1, 0), 4),
            new ConfigurationCarte(new Attaque("Salve de canon", 
                    "Vous ordonnez à vos marins d’armer les canons et de faire feu"
                            +" faisant perdre deux point de vie à votre adversaire."
                            +" Vous oubliez cependant dans l’excitation de vous boucher"
                            +" les oreilles et perdez un point de vie. ", 2, 1), 4),
            new ConfigurationCarte(new Attaque("Lancer de grappin", 
                    "Les lancers de grappin abîment le vaisseau de votre adversaire,"
                            +" lui faisant perdre un point de vie.", 1, 0), 4),
            
            
        };
        
        return cartes;
    }
}
