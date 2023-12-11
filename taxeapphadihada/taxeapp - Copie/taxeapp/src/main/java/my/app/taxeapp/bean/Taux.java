package my.app.taxeapp.bean;
import jakarta.persistence.*;
@Entity
    public class Taux {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    private String reference;
    private double surface;
    private double montantParMetreCarre;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;



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

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getMontantParMetreCarre() {
        return montantParMetreCarre;
    }

    public void setMontantParMetreCarre(double montantParMetreCarre) {
        this.montantParMetreCarre = montantParMetreCarre;
    }

    public Terrain getTerrain() {
        return terrain;
    }
    public Taux() {

    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public Taux(double surface, double montantParMetreCarre, Terrain terrain) {
        this.surface = surface;
        this.montantParMetreCarre = montantParMetreCarre;
        this.terrain = terrain;
    }
}




