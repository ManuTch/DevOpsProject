package my.app.taxeapp.bean;

import jakarta.persistence.*;

import java.io.Serializable;

    @Entity
    public class Terrain {

        @Id
        private Long reference;
        @ManyToOne
        private Categorie categorie;
        private Integer dateAchat;
        private Integer datedernierpaiment;
        @ManyToOne
        private User user;


        public Long getReference() {
            return reference;
        }

        public void setReference(Long reference) {
            this.reference = reference;
        }

        public Categorie getCategorie() {
            return categorie;
        }

        public void setCategorie(Categorie categorie) {
            this.categorie = categorie;
        }

        public Integer getDateAchat() {
            return dateAchat;
        }

        public void setDateAchat(Integer dateAchat) {
            this.dateAchat = dateAchat;
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


