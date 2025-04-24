package noyauFonctionnel.entity.cartes;

import java.util.Objects;

public class Popularite extends Carte {
    private final int pointDePop;
    private final int selfDegats;
    
    public Popularite(String nom, String description, int pointDePop, int selfDegats) {
        super(nom, description);
        this.pointDePop = pointDePop;
        this.selfDegats = selfDegats;
    }

    public int getPointDepPop() {
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
        return pointDePop == p.getPointDepPop() && selfDegats == p.getSelfDegats();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pointDePop, selfDegats);
    }
}
