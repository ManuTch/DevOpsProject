package my.app.taxeapp.service;

import my.app.taxeapp.bean.Taux;
import my.app.taxeapp.bean.Terrain;
import my.app.taxeapp.service.TerrainService;
import my.app.taxeapp.repository.TauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TauxService {

    private final TauxRepository tauxRepository;

    public Taux getTauxByTerrain(Terrain terrain) {

        Optional<Taux> optionalTaux = tauxRepository.findByTerrain(terrain);

        return optionalTaux.orElse(null);
    }


    @Autowired
    public TauxService(TauxRepository tauxRepository) {
        this.tauxRepository = tauxRepository;
    }

    public List<Taux> getAllTaux() {
        return tauxRepository.findAll();
    }

    public Taux getTauxById(Long id) {
        Optional<Taux> optionalTaux = tauxRepository.findById(id);
        return optionalTaux.orElse(null);
    }

    public Taux createTaux(Taux taux) {

        return tauxRepository.save(taux);
    }

    public Taux updateTaux(Long id, Taux updatedTaux) {
        Optional<Taux> optionalTaux = tauxRepository.findById(id);
        if (optionalTaux.isPresent()) {

            Taux existingTaux = optionalTaux.get();


            return tauxRepository.save(existingTaux);
        }
        return null;
    }

    public void deleteTaux(Long id) {
        tauxRepository.deleteById(id);
    }
    }

