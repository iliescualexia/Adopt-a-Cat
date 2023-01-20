package com.example.adoptacat.Controllers;

import com.example.adoptacat.Entities.Cat;
import com.example.adoptacat.Entities.User;
import com.example.adoptacat.Services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {
    @Autowired
    CatService catService;

    @RequestMapping(value="/api/v1/cat",method = RequestMethod.POST)
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat){
        try{
            catService.addCat(cat);
            return new ResponseEntity<>(cat, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/api/v1/cat",method = RequestMethod.DELETE)
    public void deleteCat(@RequestBody Cat cat) {
        catService.deleteCat(cat);
    }

    @RequestMapping(value="/api/v1/cat",method = RequestMethod.GET)
    public List<Cat> getAllCats(){
        return catService.getAllCats();
    }
}
