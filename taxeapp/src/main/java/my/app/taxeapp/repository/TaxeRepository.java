package my.app.taxeapp.repository;

import my.app.taxeapp.bean.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Long> {
    // You can add custom query methods here if needed
}
