package my.app.taxeapp.service;
import my.app.taxeapp.bean.Taux;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    private static  TerrainRepository terrainRepository;
    public static Terrain getTerrainByType(String terrainType) {

        Optional<Terrain> optionalTerrain = terrainRepository.findByTerrainType(terrainType);

        return optionalTerrain.orElse(null);
    }

    @Autowired
    private TauxService tauxService;
    public double calculateTaxByTerrainType(String terrainType, double surface) {
        Terrain terrain = getTerrainByType(terrainType);
        Taux taux = tauxService.getTauxByTerrain(terrain);
        return taux.getMontantParMetreCarre() * surface;
    }
    @Autowired
    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Terrain getTerrainByReference(Long reference) {
        Optional<Terrain> terrainOptional = terrainRepository.findById(reference);
        return terrainOptional.orElse(null);
    }

    public Terrain createTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public Terrain updateTerrain(Long reference, Terrain updatedTerrain) {
        Optional<Terrain> existingTerrainOptional = terrainRepository.findById(reference);

        if (existingTerrainOptional.isPresent()) {
            Terrain existingTerrain = existingTerrainOptional.get();
            existingTerrain.setCategorie(updatedTerrain.getCategorie());
            existingTerrain.setDateAchat(updatedTerrain.getDateAchat());
            existingTerrain.setDatedernierpaiment(updatedTerrain.getDatedernierpaiment());
            existingTerrain.setUser(updatedTerrain.getUser());

            return terrainRepository.save(existingTerrain);
        } else {
            return null; // Handle not found case
        }
    }

    public void deleteTerrain(Long reference) {
        terrainRepository.deleteById(reference);
    }
    public static Terrain saveTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }
}
