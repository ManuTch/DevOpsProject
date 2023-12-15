package my.app.taxeapp.controller;

import my.app.taxeapp.bean.Categorie;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.service.TaxeCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/tax")
public class TaxeController {

    @Autowired
    private TaxeCalculationService taxCalculationService;

    @PostMapping("/calculateTax")
    public String calculateTax(
            @RequestParam(name = "cin") String cin,
            @RequestParam(name = "year") Integer year,
            @RequestParam(name = "categorie_id") Integer categorie,
            Model model) {


        Terrain terrain = taxCalculationService.getTerrainByCin(cin);
        Integer b=terrain.getDatedernierpaiment();


            int minYear = 2020;
            int maxYear = 2022;
            int a;
            if (year >= minYear && year <= maxYear) {
                a = 3;
            } else {
                a = 1;
            }
        if (year >= b) {


        double surface = terrain.getSurface();
        double montantParMetreCarre = terrain.getCategorie().getTaux().get(0).getMontantParMetreCarre();
        double Tax = a * surface * montantParMetreCarre;
        model.addAttribute("Tax", Tax);
        return "TaxResult";
        } else {
            return "TaxPay";

    }
    }

    }
