package boundary;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import util.EnumCarte;
import vue.ui.dialog.AdaptateurDuNoyauFonctionnel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wer, Solène
 */
public class MainConsole {
    private final Scanner scanner;
    private final AdaptateurDuNoyauFonctionnel adaptateur;
    
    public MainConsole(AdaptateurDuNoyauFonctionnel adaptateur) {  
        this.adaptateur=adaptateur;
        this.scanner = new Scanner(System.in);
    }
    
    public String carteString(int id){
        StringBuilder result = new StringBuilder();
        EnumCarte type = adaptateur.getType(id);
        result.append(type);
        result.append(" : {nom : ");
        result.append(adaptateur.getNom(id));
        switch (type){
            case POPULARITE -> {
                result.append(", ");
                result.append("pointPop : ");
                result.append(adaptateur.getPointPopularite(id));
                int selfDegats = adaptateur.getSelfDegat(id);
                if (selfDegats > 0) {
                    result.append(", selfDegats : ");
                    result.append(selfDegats);
                }
            }
            case ATTAQUE -> {
                result.append(", ");
                result.append("actionVie : ");
                result.append(adaptateur.getActionVie(id));
                int selfDegats = adaptateur.getSelfDegat(id);
                if (selfDegats > 0) {
                    result.append(", selfDegats : ");
                    result.append(selfDegats);
                }
            }
            case PROTECTION -> {
                result.append(", ");
                result.append("attaqueBloquee : ");
                result.append(adaptateur.getNomAttaqueBloque(id));
            }
            case ECHANGE -> {
                // pad d'information additionelles
            }
            case GAIN_VIE -> {
                result.append(", ");
                result.append("gainVie : ");
                result.append(adaptateur.getGainVie(id));
            }
            default -> throw new AssertionError(type.name());
        }
        result.append('}');
        return result.toString();
    }
    
    private void printListeCarte(List<Integer> liste) {
        Iterator<Integer> it = liste.iterator();
        System.out.print("[");
        if (it.hasNext()) {
            System.out.print(carteString(it.next()));
        }
        while (it.hasNext()) {
            System.out.print(", ");
            System.out.print(carteString(it.next()));
        }
        System.out.print(']');
    }
    
    private void afficherJeu(String nomJoueur1, String nomJoueur2) {
        System.out.println("#################################################");
        
        int pvJoueur1 = adaptateur.getPointDeVieJ1();
        int pvJoueur2 = adaptateur.getPointDeVieJ2();
        
        int popJoueur1 = adaptateur.getIndicePopulariteJ1();
        int popJoueur2 = adaptateur.getIndicePopulariteJ2();
        
        List<Integer> mainJoueur1 = adaptateur.getMainJoueur1();
        List<Integer> mainJoueur2 = adaptateur.getMainJoueur2();
        
        List<Integer> zonePopJoueur1 = adaptateur.getZonePopulariteJ1();
        List<Integer> zonePopJoueur2 = adaptateur.getZonePopulariteJ2();
        
        List<Integer> action = adaptateur.getZoneAction();
        
        System.out.println(nomJoueur1 + " a "+pvJoueur1+" point de vie et "+popJoueur1+" point de popularite");
        System.out.print("Sa zone de popularité est composé de ");
        printListeCarte(zonePopJoueur1);
        System.out.println();
        System.out.print("Il a dans la main ");
        printListeCarte(mainJoueur1);
        System.out.println();
        
        
        System.out.println("---------------------------------------------------");
        
        System.out.println(nomJoueur2 + " a "+pvJoueur2+" point de vie et "+popJoueur2+" point de popularite");
        System.out.print("Sa zone de popularité est composé de ");
        printListeCarte(zonePopJoueur2);
        System.out.println();
        System.out.print("Il a dans la main ");
        printListeCarte(mainJoueur2);
        System.out.println();
        
        System.out.print("La zone action est composé de ");
        printListeCarte(action);
        System.out.println();
        System.out.println("#################################################");
    }
    
    public void lancerJeu() {
        try (scanner) {
            System.out.println("Début du jeu !");
            String nomJ1;
            do {
                System.out.print("Joueur 1, entrez votre nom : ");
                nomJ1 = scanner.nextLine();
            } while (nomJ1.trim().isEmpty());
            
            adaptateur.setNomJoueur1(nomJ1);
            
            String nomJ2;
            do {
                System.out.print("Joueur 2, Entrez votre nom : ");
                nomJ2 = scanner.nextLine();
            } while (nomJ2.trim().isEmpty());
            
            adaptateur.setNomJoueur2(nomJ2);
            
            while (!adaptateur.verifierFinPartie()) {
                afficherJeu(nomJ1,nomJ2);
                
                boolean tour = adaptateur.getTourDeJeu();
                if (tour) {
                	System.out.println("Tour de " + nomJ1 + " (joueur 1)");	
                } else {
                	System.out.println("Tour de " + nomJ2 + " (joueur 2)");	
                }
                
                int indexCarte = -1;
                do {
                    System.out.print("Choisissez une carte (index entre 1 et 4) : ");
                    
                    if (scanner.hasNextInt()) {
                        indexCarte = scanner.nextInt();
                    } else {
                        System.out.println("Entrée invalide. Veuillez entrer un entier.");
                        scanner.next();
                    }
                } while (indexCarte < 1 || indexCarte > 4);
                
                List<Integer> mainJoueurCurr = adaptateur.getTourDeJeu() ? adaptateur.getMainJoueur1() : adaptateur.getMainJoueur2();
                int carteChoisie = mainJoueurCurr.get(indexCarte - 1);
                
                adaptateur.deposerCarte(carteChoisie);
                adaptateur.appliquerEffetCarte(carteChoisie);
                adaptateur.removeCarteMainJoueur(carteChoisie);
                System.out.println("Votre carte est posée");
                int cartePiochee=adaptateur.piocher();
                adaptateur.joueurPrendreCarte(cartePiochee);
                System.out.println("Vous piochez la carte "+carteString(cartePiochee));
                
                System.out.println("On change de Joueur.");
                adaptateur.changerJoueur();
            }
            
            System.out.println("#################################################");
            
            String typeVictoire = adaptateur.getTypeVictoire();
            String nomGagnant = adaptateur.getNomGagnant();
            
            if (typeVictoire.equals("égalité")) {
            	System.out.println("Egalité !");
            } else {
            	System.out.println(nomGagnant + " a gagné par " + typeVictoire);
            }
        }
    }
}
