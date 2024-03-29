package my.app.taxeapp.bean;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Categorie {

        @OneToMany(mappedBy = "categorie")
        private List<Terrain> terrains;

        @OneToMany(mappedBy = "categorie")
        private List<Taux> taux;
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

    @Override
    public String toString() {
        return "com.sir.taxeTNBapi.bean.CategorieTnb[ id=" + id + " ]";
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
