package com.example.adoptacat.Services;

import com.example.adoptacat.Entities.Breed;
import com.example.adoptacat.Entities.Cat;
import com.example.adoptacat.Repositories.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService {
    @Autowired
    private BreedRepository breedRepository;
    public void addBreed(Breed breed){
        breedRepository.save(breed);
    }
    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }
}
