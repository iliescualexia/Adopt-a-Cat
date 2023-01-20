package com.example.adoptacat.Controllers;

import com.example.adoptacat.Entities.Cat;
import com.example.adoptacat.Entities.Shelter;
import com.example.adoptacat.Services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShelterController {
    @Autowired
    ShelterService shelterService;

    @RequestMapping(value="/api/v1/shelter",method= RequestMethod.POST)
    public void addShelter(@RequestBody Shelter shelter){
        shelterService.addShelter(shelter);
    }
    @RequestMapping(value="/api/v1/shelter",method = RequestMethod.GET)
    public List<Shelter> getShelters(){
        return shelterService.getShelters();
    }
    @RequestMapping(value="/api/v1/shelter/addcat",method= RequestMethod.POST)
    public void addCatToShelter(@RequestBody Map<String,String> request){
        shelterService.addCatToShelter(request.get("shelterid"),request.get("catId"));
    }
    @RequestMapping(value="/api/v1/findshelter",method= RequestMethod.POST)
    public Shelter findCatInShelter(@RequestBody Cat cat){
        return shelterService.findCatInShelter(cat);
    }
}
