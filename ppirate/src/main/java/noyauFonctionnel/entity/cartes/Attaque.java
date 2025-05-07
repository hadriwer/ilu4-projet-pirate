package noyauFonctionnel.entity.cartes;

import java.util.Objects;

public class Attaque extends Carte {
    private final int actionVie;
    private final int selfDegats;
    
    public Attaque(String nom, String description, int actionVie, int selfDegats) {
        super(nom, description);
        effet = (self,cible) -> {
            if (cible.peutAttaquer(this)) {
                self.perdreVie(selfDegats);
                cible.perdreVie(actionVie);
            }
        };
        this.actionVie = actionVie;
        this.selfDegats = selfDegats;
    }

    public int getActionVie() {
        return actionVie;
    }
    
    public int getSelfDegats() {
        return selfDegats;
    }
    
    @Override
    public String toString() {
        return "Attaque[nom=" + this.getNom() + ", degat=" + actionVie + ", auto-degat=" + selfDegats + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // check attributs de la superclass
        Attaque a = (Attaque) o;
        return actionVie == a.getActionVie() && selfDegats == a.getSelfDegats();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), actionVie, selfDegats);
    }
}
