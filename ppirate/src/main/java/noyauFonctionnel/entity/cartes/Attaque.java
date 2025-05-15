package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import util.EnumCarte;

public class Attaque extends Carte {
    private final int actionVie;
    private final int selfDegats;
    
    public Attaque(int id, String nom, String description, int actionVie, int selfDegats) {
        super(id, nom, description);
        this.actionVie = actionVie;
        this.selfDegats = selfDegats;
        
        setEffet((self,cible) -> {
            if (cible.peutAttaquer(this)) {
                self.perdreVie(selfDegats);
                cible.perdreVie(actionVie);
            }
        });
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
    
    @Override
    public Attaque copie() {
        return new Attaque(id, nom, description, actionVie, selfDegats);
    }

    @Override
    public EnumCarte getType() {
        return EnumCarte.ATTAQUE;
    }
    
}
