package com.example.adoptacat.Services;

import com.example.adoptacat.Entities.Cat;
import com.example.adoptacat.Entities.Shelter;
import com.example.adoptacat.Repositories.CatRepository;
import com.example.adoptacat.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {
    @Autowired
    private ShelterRepository shelterRepository;
    @Autowired
    private CatRepository catRepository;
    public void addShelter(Shelter shelter){
        shelterRepository.save(shelter);
    }
    public List<Shelter> getShelters(){
        return shelterRepository.findAll();
    }
    public void addCatToShelter(String shelterid,String catid){
        Shelter shelter=shelterRepository.findByShelterid(Long.parseLong(shelterid));
        Cat cat=catRepository.findByCatId(Long.parseLong(catid));
        shelter.getCat().add(cat);
        shelterRepository.save(shelter);
    }
    public Shelter findCatInShelter(Cat cat){
        List<Shelter> shelters=shelterRepository.findAll();
        Shelter shelter = null;
        for (Shelter value : shelters) {
            for (int j = 0; j < value.getCat().size(); j++) {
                if (value.getCat().get(j).getCatId()==cat.getCatId()) {
                    shelter = value;
                    break;
                }
            }
        }
        return shelter;
    }
}
