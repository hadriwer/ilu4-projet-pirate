package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import util.EnumCarte;

public class Popularite extends Carte {
    private final int pointDePop;
    private final int selfDegats;
    
    public Popularite(int id, String nom, String description, int pointDePop, int selfDegats) {
        super(id, nom, description);
        this.pointDePop = pointDePop;
        this.selfDegats = selfDegats;
        
        setEffet((self, cible) -> {self.gagnerPop(pointDePop); self.perdreVie(selfDegats);});
    }

    public int getPointDePop() {
        return pointDePop;
    }
    
    public int getSelfDegats() {
        return selfDegats;
    }
    
    @Override
    public String toString() {
        return "Popularite[nom=" + this.getNom() + ", gain=" + pointDePop + ", auto-degat=" + selfDegats + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // check attributs de la superclass
        Popularite p = (Popularite) o;
        return pointDePop == p.getPointDePop() && selfDegats == p.getSelfDegats();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pointDePop, selfDegats);
    }
    
    @Override
    public Popularite clone() {
        return new Popularite(id, nom, description, pointDePop, selfDegats);
    }

    @Override
    public EnumCarte getType() {
        return EnumCarte.POPULARITE;
    }
    
}
