package my.app.taxeapp.bean;

import jakarta.persistence.*;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    @Column(length = 45, nullable = false)
    private String cin;
    @Column(length = 45, nullable =false, name = "first_name")
    private String firstname;
    @Column(length = 45, nullable = false, name = "last_name")
    private String lastname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Terrain getterrain() {
        return terrain;
    }

    public void setterrain() {
        this.terrain = terrain;
    }

    public String getcin() {
        return cin;
    }

    public void setcin(String password) {
        this.cin = cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", terrain='" + terrain + '\'' +
                ", cin='" + cin + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
