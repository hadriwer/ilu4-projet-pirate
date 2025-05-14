package util;

import java.util.HashMap;
import java.util.Map;

import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.GainVie;
import noyauFonctionnel.entity.cartes.Protection;
import noyauFonctionnel.entity.cartes.Popularite;
import noyauFonctionnel.entity.cartes.Echange;

/**
 *
 * @author ember
 */

public class CarteFactory {
    private CarteFactory() {
        throw new IllegalStateException("Utility class");
    }
    
    public static Map<Carte, Integer> creerCartes() {
        // Cartes de popularité
        Popularite mainDeFer = new Popularite(0,"Main de fer", 
            "À la suite d'un bras de fer devant les membres d'équipage vous gagnez deux points de popularité, mais votre effort vous coûte un point de vie.", 
            2, 1);

        Popularite abordageReussi = new Popularite(0,"Abordage réussi", 
            "Au cours d’un abordage, vous faites preuve d’une grande bravoure et gagnez deux points de popularité.", 
            2, 0);

        Popularite discoursInspirant = new Popularite(0,"Discours inspirant", 
            "Avant un abordage, vous inspirez vos troupes et gagnez ainsi un point de popularité.", 
            1, 0);

        Popularite grandeDescente = new Popularite(0,"Grande descente", 
            "Suite à une beuverie avec l’équipage, vous prouvez votre supériorité et finissez victorieux, gagnant ainsi le respect de vos matelots et deux points de popularité. Malheureusement vous finissez la soirée avec le foie en compote et perdez deux points de vie.", 
            2, 2);

        Popularite revolteSimultanee = new Popularite(0,"Révolte simultanée", 
            "Suite à une mutinerie, vous imposez votre autorité et restez capitaine, gagnant ainsi un point de popularité.", 
            1, 0);

        Popularite butinInestimable = new Popularite(0,"Butin inestimable", 
            "Vous et votre équipage vous approchez d’une île en plein combat. Contre les conseils de votre second et du maître d’équipage, vous décidez de prendre le risque et ordonnez à quelques hommes d’aller y déterrer un potentiel trésor. Votre instinct vous rapporte trois gros coffres bien remplis et trois points de popularité.", 
            3, 0);

        Popularite ventEnPoupe = new Popularite(0,"Vent en poupe", 
            "De par votre expérience, vous ordonnez à l’équipage de changer de cap pour vous aider d’une rafale opportune. Vous gagnez en vitesse et remportez un point de popularité.", 
            1, 0);

        // Cartes d'attaque
        Attaque bombeArtisanale = new Attaque(0,"Bombe artisanale", 
            "Vous avez fait exploser un baril de poudre proche de votre adversaire qui perd deux points de vie. Malheureusement vous étiez trop proche et perdez un point de vie.", 
            2, 1);

        Attaque coupDeSabre = new Attaque(0,"Coup de sabre", 
            "Un coup de sabre parfaitement exécuté fait perdre deux points de vie à votre adversaire.", 
            2, 0);

        Attaque abordage = new Attaque(0,"Abordage", 
            "Vous dirigez un abordage contre votre adversaire et sortez victorieux, faisant perdre 2 points de vie à votre adversaire.", 
            2, 0);

        Attaque bouteilleCassee = new Attaque(0,"Bouteille cassée", 
            "Vous vous armez d’une bouteille de rhum cassée et frappez votre adversaire sur la tête. Malheureusement son couvre-chef l’a protégé et il ne perd qu’un point de vie.", 
            1, 0);

        Attaque salveDeCanon = new Attaque(0,"Salve de canon", 
            "Vous ordonnez à vos marins d’armer les canons et de faire feu, faisant perdre deux points de vie à votre adversaire. Vous oubliez cependant dans l’excitation de vous boucher les oreilles et perdez un point de vie.", 
            2, 1);

        Attaque lancerDeGrappin = new Attaque(0,"Lancer de grappin", 
            "Les lancers de grappin abîment le vaisseau de votre adversaire, lui faisant perdre un point de vie.", 
            1, 0);

        // Cartes de protection
        Protection nezDeFer = new Protection(0,"Nez de fer", 
            "Vos nombreuses années au service de la piraterie vous ont donné le don de sentir la poudre à des kilomètres à la ronde. Vous savez empêcher un pirate de vous faire sauter.", 
            bombeArtisanale);

        Protection escrimeDeJeunesse = new Protection(0,"Escrime de jeunesse", 
            "Vous étiez minot avant d’être pirate et vous souvenez encore de vos leçons d’escrime. Votre adversaire ne peut vous toucher avec un sabre, il devra tenter autre chose.", 
            coupDeSabre);

        Protection equipageEfficace = new Protection(0,"Equipage efficace", 
            "Vous êtes béni d’un équipage très performant qui empêche à quiconque de monter à bord. Les abordages ne prennent pas contre vous.", 
            abordage);

        Protection chapeauBas = new Protection(0,"Chapeau bas", 
            "L’air marin vous donne toujours froid au crâne et vous vous pavanez toujours par conséquent avec un tricorne de plus sous votre premier. Aucun coup à la tête ne saura vous atteindre.", 
            bouteilleCassee);

        Protection navireInsubmersible = new Protection(0,"Navire insubmersible", 
            "Vous avez paré votre fier vaisseau des dernières technologies existantes contre les boulets de canon. Pas un n’éventra votre navire.", 
            salveDeCanon);

        Protection charismeIntimidant = new Protection(0,"Charisme intimidant", 
            "Votre réputation de pirate sanguinaire intimide l’équipage de votre adversaire, les faisant trembler lors de leurs lancements de grappins. Pas un n’effleure donc votre navire.", 
            lancerDeGrappin);
        
        // Carte d'échange
        Echange EchangeButin = new Echange(0, "Echange de Butin","Vous envoyez un de vos matelot faire un échange de trésor aléatoire avec l'ennemi");
        
        
        // Cartes gain de vie
        GainVie repasFestif = new GainVie(0, "Repas Festif",
                "Après vous être rempli l'estomac vous vous sentez tout de suite mieux. Vous gagnez deux points de vie.", 2);
        
        GainVie eauDeVie = new GainVie(0, "Eau de Vie",
                "La modération est la clé. Vous êtes un pirate, boire de la gnôle vous redonne un point de vie.", 1);
        
        GainVie merDesinfectante = new GainVie(0, "Mer Désinfectante",
                "Votre très chère mer désinfecte et accélère la guérison de vos blessure", 3);

        // Assemblage
        Map<Carte, Integer> configuration = new HashMap<Carte, Integer>();
        
        configuration.put(mainDeFer, 4);
        configuration.put(abordageReussi, 4);
        configuration.put(discoursInspirant, 4);
        configuration.put(grandeDescente, 4);
        configuration.put(revolteSimultanee, 4);
        configuration.put(butinInestimable, 4);
        configuration.put(ventEnPoupe, 4);

        configuration.put(bombeArtisanale, 4);
        configuration.put(coupDeSabre, 4);
        configuration.put(abordage, 4);
        configuration.put(bouteilleCassee, 4);
        configuration.put(salveDeCanon, 4);
        configuration.put(lancerDeGrappin, 4);

        configuration.put(nezDeFer, 1);
        configuration.put(escrimeDeJeunesse, 1);
        configuration.put(equipageEfficace, 1);
        configuration.put(chapeauBas, 1);
        configuration.put(navireInsubmersible, 1);
        configuration.put(charismeIntimidant, 1);

        configuration.put(EchangeButin, 1);
        
        configuration.put(repasFestif, 4);
        configuration.put(eauDeVie, 4);
        configuration.put(merDesinfectante, 2);
        
        return configuration;
            
    }
}
