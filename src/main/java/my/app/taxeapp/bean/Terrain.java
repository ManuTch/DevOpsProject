package my.app.taxeapp.bean;

import jakarta.persistence.*;

import java.io.Serializable;

    @Entity
    public class Terrain {
        @Id
        private Long id;

        public void setSurface(double surface) {
            this.surface = surface;
        }

        private double surface;

        public double getSurface() {
                return surface;
            }

        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "categorie_id")
        private Categorie categorie;
        private Integer datedernierpaiment;
        @ManyToOne
        private User user;


        public Categorie getCategorie() {
            return categorie;
        }

        public void setCategorie(Categorie categorie) {
            this.categorie = categorie;
        }


        public Integer getDatedernierpaiment() {
            return datedernierpaiment;
        }

        public void setDatedernierpaiment(Integer datedernierpaiment) {
            this.datedernierpaiment = datedernierpaiment;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }


