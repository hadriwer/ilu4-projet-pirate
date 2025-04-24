package noyauFonctionnel.entity.cartes;

import java.util.Objects;

public abstract class Carte implements Cloneable {
    private final String nom;
    private final String description;
    
    public Carte(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }    
    
    public String getNom() {
       return nom;
    }
    
    public String getDescription() {
        return description;
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
    public Carte clone() {
        try {
            // tous les attributs de Carte sont immuables (2 string), pas besoin
            // de les re cloner en plus, leur référence sera changée dans tous les cas
            return (Carte) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
