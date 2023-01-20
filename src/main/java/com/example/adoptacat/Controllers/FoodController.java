package com.example.adoptacat.Controllers;

import com.example.adoptacat.Entities.Breed;
import com.example.adoptacat.Entities.Food;
import com.example.adoptacat.Services.BreedService;
import com.example.adoptacat.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping(value="/api/v1/food",method= RequestMethod.POST)
    public void addFood(@RequestBody Food food){foodService.addFood(food);}
    @RequestMapping(value="/api/v1/food",method = RequestMethod.GET)
    public List<Food> getAllFoods(){
        return foodService.getAllFoods();
    }
}
