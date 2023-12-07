package my.app.taxeapp.bean;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Categorie {

        @OneToMany(mappedBy = "categorie")
        private List<Terrain> terrains;

        @OneToMany(mappedBy = "categorie")
        private List<Taux> taux;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String reference;

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
    }

    public List<Taux> getTaux() {
        return taux;
    }

    public void setTaux(List<Taux> taux) {
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
