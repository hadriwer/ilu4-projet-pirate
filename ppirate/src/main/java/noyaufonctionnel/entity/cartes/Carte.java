package noyaufonctionnel.entity.cartes;

import java.util.Objects;
import noyaufonctionnel.entity.Joueur;
import util.EnumCarte;

public abstract class Carte {
    protected int id;
    protected final String nom;
    protected final String description;
    private IEffetCarte effet;
    
    
    protected Carte(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public abstract EnumCarte getType(); 
    
    public void setEffet(IEffetCarte effet) {
        this.effet = effet;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
       return nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void apply(Joueur self, Joueur cible) {
        effet.apply(self, cible);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nom, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carte other = (Carte) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    public abstract Carte copie();
}
