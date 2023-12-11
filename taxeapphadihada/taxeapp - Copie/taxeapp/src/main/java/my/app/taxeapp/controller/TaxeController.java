package my.app.taxeapp.controller;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.bean.User;
import my.app.taxeapp.service.TerrainService;
import my.app.taxeapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import my.app.taxeapp.bean.TaxForm;
import my.app.taxeapp.service.TaxeCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static my.app.taxeapp.service.TerrainService.*;

@Controller
@RequestMapping("/api/tax")
public class TaxeController {

    @Autowired
    private TaxeCalculationService taxCalculationService;

    @PostMapping("/calculateTax")
    public String calculateTax(
            @RequestParam(name = "cin") String cin,
            @RequestParam(name = "year") Integer year,
            @RequestParam(name = "terrainType") String terrainType,
            Model model) {

        Terrain terrain;
        if ("villa".equalsIgnoreCase(terrainType)) {
            terrain = new Terrain();
            terrain.setSurface(300.0);
        } else if ("maison".equalsIgnoreCase(terrainType)) {
            terrain = new Terrain();
            terrain.setSurface(200.0);
        } else if ("appartement".equalsIgnoreCase(terrainType)) {
            terrain = new Terrain();
            terrain.setSurface(150.0);
        } else {
            terrain = null;
        }

        User user = UserService.getUserByCin(cin);

        double tax = (terrain != null) ? 2 * terrain.getSurface() : 0.0;

        model.addAttribute("tax", tax);
        return "taxResult";
    }
}


