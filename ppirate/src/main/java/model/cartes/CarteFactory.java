package model.cartes;

/**
 *
 * @author ember
 */

public class CarteFactory {
    public static ConfigurationCarte[] creerCartes() {
        ConfigurationCarte[] cartes = new ConfigurationCarte[] {
            new ConfigurationCarte(new Popularite("Main de fer", 
                    "À la suite d'un bras de fer devant les membres d'équipage "
                            + "le pirate gagne deux points de popularité, mais "
                            + "son effort lui coûte un point de vie.", 2, 1), 4),
            new ConfigurationCarte(new Popularite("Abordage réussi", 
                    "Au cours d’un abordage, le pirate fait preuve d’une grande "
                            + "bravoure et gagne deux points de popularité.", 2, 0), 4),
            new ConfigurationCarte(new Popularite("Discours inspirant", 
                    "Avant un abordage, le pirate inspire ses troupes et gagne "
                            + "ainsi un point de popularité.", 1, 0), 4),
            new ConfigurationCarte(new Popularite("Grande descente", 
                    "Suite à une beuverie, le pirate a prouvé sa supériorité et "
                            + "a finit victorieux, gagnant ainsi le respect de "
                            + "ses matelots et deux points de popularité. "
                            + "Malheureusement il finit la soirée avec le foie "
                            + "en compote et perd deux points de vies.", 2, 2), 4),
        };
        
        return cartes;
    }
}
