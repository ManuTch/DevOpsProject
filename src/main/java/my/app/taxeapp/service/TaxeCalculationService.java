package my.app.taxeapp.service;

import my.app.taxeapp.bean.Categorie;
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

    public Terrain getTerrainByCin(String cin) {
        User user = userService.getUserByCin(cin);
        return terrainService.getTerrainByUser(user);
    }


    }
