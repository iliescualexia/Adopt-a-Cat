package com.example.adoptacat.Services;

import com.example.adoptacat.Entities.Cat;
import com.example.adoptacat.Entities.Owner;
import com.example.adoptacat.Entities.Shelter;
import com.example.adoptacat.Repositories.CatRepository;
import com.example.adoptacat.Repositories.OwnerRepository;
import com.example.adoptacat.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private ShelterRepository shelterRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public void addCat(Cat cat){
        catRepository.save(cat);
    }
    public void deleteCat(Cat cat){
        List<Shelter> shelters=shelterRepository.findAll();
        for (Shelter value : shelters) {
            for (int j = 0; j < value.getCat().size(); j++) {
                if (value.getCat().get(j).getCatId()==cat.getCatId()) {
                    value.getCat().remove(value.getCat().get(j));
                }
            }
        }
        List<Owner> owners=ownerRepository.findAll();
        for (Owner value : owners) {
            for (int j = 0; j < value.getCats().size(); j++) {
                if (value.getCats().get(j).getCatId()==cat.getCatId()) {
                    value.getCats().remove(value.getCats().get(j));
                }
            }
        }
        catRepository.deleteById(cat.getCatId()
        );
    }
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }
}
