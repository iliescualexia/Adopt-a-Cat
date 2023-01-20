package com.example.adoptacat.Services;

import com.example.adoptacat.Entities.Breed;
import com.example.adoptacat.Entities.Food;
import com.example.adoptacat.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    public void addFood(Food food){
        foodRepository.save(food);
    }
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }
}
