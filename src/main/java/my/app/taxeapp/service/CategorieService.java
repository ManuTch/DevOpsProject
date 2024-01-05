package my.app.taxeapp.service;


import my.app.taxeapp.bean.Categorie;
import my.app.taxeapp.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class CategorieService {

        private final CategorieRepository categorieRepository;

        @Autowired
        public CategorieService(CategorieRepository categorieRepository) {
            this.categorieRepository = categorieRepository;
        }

        public List<Categorie> getAllCategories() {
            return categorieRepository.findAll();
        }

        public Categorie getCategoryById(Long id) {
            Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
            return optionalCategorie.orElse(null);
        }

        public Categorie createCategory(Categorie categorie) {
            return categorieRepository.save(categorie);
        }

        public Categorie updateCategory(Long id, Categorie updatedCategorie) {
            Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
            if (optionalCategorie.isPresent()) {
                Categorie existingCategorie = optionalCategorie.get();

                return categorieRepository.save(existingCategorie);
            }
            return null;
        }

        public void deleteCategory(Long id) {
            categorieRepository.deleteById(id);
        }
    }

