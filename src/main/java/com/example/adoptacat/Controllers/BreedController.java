package com.example.adoptacat.Controllers;

import com.example.adoptacat.Entities.Breed;
import com.example.adoptacat.Services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BreedController {
    @Autowired
    private BreedService breedService;

    @RequestMapping(value = "/api/v1/breed",method = RequestMethod.POST)
    public void addBreed(@RequestBody Breed breed){
        breedService.addBreed(breed);
    }
    @RequestMapping(value="/api/v1/breed",method = RequestMethod.GET)
    public List<Breed> getAllBreeds(){
       return breedService.getAllBreeds();
    }
}
