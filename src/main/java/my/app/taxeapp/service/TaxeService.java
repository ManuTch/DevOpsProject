package my.app.taxeapp.service;

import my.app.taxeapp.bean.Taxe;
import my.app.taxeapp.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {

    private final TaxeRepository taxeRepository;

    @Autowired
    public TaxeService(TaxeRepository taxeRepository) {
        this.taxeRepository = taxeRepository;
    }

    public List<Taxe> getAllTaxes() {
        return taxeRepository.findAll();
    }

    public Taxe getTaxeById(Long id) {
        Optional<Taxe> optionalTaxe = taxeRepository.findById(id);
        return optionalTaxe.orElse(null);
    }

    public Taxe createTaxe(Taxe taxe) {

        return taxeRepository.save(taxe);
    }

    public Taxe updateTaxe(Long id, Taxe updatedTaxe) {
        Optional<Taxe> optionalTaxe = taxeRepository.findById(id);
        if (optionalTaxe.isPresent()) {

            Taxe existingTaxe = optionalTaxe.get();
            existingTaxe.setTaux(updatedTaxe.getTaux());
            existingTaxe.setTerrain(updatedTaxe.getTerrain());


            return taxeRepository.save(existingTaxe);
        }
        return null;
    }

    public void deleteTaxe(Long id) {
        taxeRepository.deleteById(id);
    }
}
