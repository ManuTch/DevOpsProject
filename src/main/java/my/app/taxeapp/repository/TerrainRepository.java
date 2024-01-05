package my.app.taxeapp.repository;

import my.app.taxeapp.bean.Categorie;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
      Optional<Terrain> findByCategorie(Categorie categorie);

      Optional<Terrain> findByUser(User user);
}
