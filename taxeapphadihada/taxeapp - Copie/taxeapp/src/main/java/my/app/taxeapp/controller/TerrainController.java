package my.app.taxeapp.controller;

import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terrains")
public class TerrainController {

    private final TerrainService terrainService;

    @Autowired
    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping
    public List<Terrain> getAllTerrains() {
        return terrainService.getAllTerrains();
    }

    @GetMapping("/{reference}")
    public Terrain getTerrainByReference(@PathVariable Long reference) {
        return terrainService.getTerrainByReference(reference);
    }

    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        return terrainService.createTerrain(terrain);
    }

    @PutMapping("/{reference}")
    public Terrain updateTerrain(@PathVariable Long reference, @RequestBody Terrain updatedTerrain) {
        return terrainService.updateTerrain(reference, updatedTerrain);
    }

    @DeleteMapping("/{reference}")
    public void deleteTerrain(@PathVariable Long reference) {
        terrainService.deleteTerrain(reference);
    }
}
