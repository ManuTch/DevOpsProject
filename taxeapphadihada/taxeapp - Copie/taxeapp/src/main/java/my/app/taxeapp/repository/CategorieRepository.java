package my.app.taxeapp.repository;

import my.app.taxeapp.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CategorieRepository extends JpaRepository<Categorie, Long> {
        // You can add custom query methods here if needed
    }
