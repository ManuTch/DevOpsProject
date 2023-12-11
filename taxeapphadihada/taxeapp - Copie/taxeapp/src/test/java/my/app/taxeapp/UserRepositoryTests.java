package my.app.taxeapp;

import my.app.taxeapp.bean.Taux;
import my.app.taxeapp.bean.Terrain;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import my.app.taxeapp.repository.UserRepository;
import my.app.taxeapp.bean.User;
import my.app.taxeapp.service.TerrainService;
import my.app.taxeapp.service.TauxService;
import my.app.taxeapp.service.UserService;



import org.junit.jupiter.api.Test;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;
    @Test
    public void testEntityCreation() {
        // Create and save a Terrain entity
        Terrain terrain = createTerrain("Villa", 100.0);
        Terrain saveTerrain = TerrainService.saveTerrain(terrain);

        // Create and save a User entity
        User user = createUser("sara", "123456789");
        UserService.saveUser(user);

        // Create and save a Taux entity
        Taux taux = createTaux(0.5); // Assuming 0.5 as an example, adjust as needed
        TauxService.saveTaux(taux);

        // You can add assertions or additional tests as needed
    }

    private Terrain createTerrain(String type, double surface) {
        Terrain terrain = new Terrain();
        terrain.setTerrainType(type);
        terrain.setSurface(surface);
        // Set other attributes as needed

        return terrain;
    }

    private User createUser(String name, String cin) {
        User user = new User();
        user.setname(name);
        user.setcin(cin);
        // Set other attributes as needed

        return user;
    }

    private Taux createTaux(double montantParMetreCarre) {
        Taux taux = new Taux();
        taux.setMontantParMetreCarre(montantParMetreCarre);
        // Set other attributes as needed

        return taux;
    }
}
