package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import noyauFonctionnel.entity.Joueur;
import util.EnumCarte;

public abstract class Carte implements Cloneable {
    protected int id;
    protected final String nom;
    protected final String description;
    private EffetCarte effet;
    
    
    protected Carte(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public abstract EnumCarte getType(); 
    
    public void setEffet(EffetCarte effet) {
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
        return Objects.hash(getNom(), getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte c = (Carte) o;
        
        return this.nom.equals(c.getNom()) && this.description.equals(c.getDescription());
    }
    
    @Override
    public abstract Carte clone();
    
}
