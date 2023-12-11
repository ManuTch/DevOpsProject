package my.app.taxeapp.service;

import my.app.taxeapp.bean.Taux;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxeCalculationService {

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private TauxService tauxService;

    @Autowired
    private UserService userService;

    public double calculateTax(Integer year, String cin, String terrainType) {
        Terrain terrain = terrainService.getTerrainByType(terrainType);
        User user = userService.getUserByCin(cin);

        double tax = 2 * terrain.getSurface();

        return tax;
    }
}
