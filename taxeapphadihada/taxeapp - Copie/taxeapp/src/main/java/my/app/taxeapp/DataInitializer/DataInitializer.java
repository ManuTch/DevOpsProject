package my.app.taxeapp.DataInitializer;

import my.app.taxeapp.service.TauxService;
import my.app.taxeapp.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.bean.Taux;



@Component
public class DataInitializer implements CommandLineRunner {

    private final TauxService tauxService;
    private final TerrainService terrainService;

    @Autowired
    public DataInitializer(TauxService tauxService, TerrainService terrainService) {
        this.tauxService = tauxService;
        this.terrainService = terrainService;
    }

    @Override
    public void run(String... args) {
        initializeTauxForTerrainType("Villa", 2.0);
        initializeTauxForTerrainType("Maison", 1.0);
        initializeTauxForTerrainType("Appartement", 0.5);
    }

    private void initializeTauxForTerrainType(String terrainType, double montantParMetreCarre) {
        Terrain terrain = terrainService.getTerrainByType(terrainType);

        if (terrain != null) {
            Taux existingTaux = tauxService.getTauxByTerrain(terrain);

            if (existingTaux == null) {
                Taux newTaux = new Taux();
                newTaux.setTerrain(terrain);
                newTaux.setMontantParMetreCarre(montantParMetreCarre);
                tauxService.saveTaux(newTaux);
            }
        }
    }
}
