package com.example.adoptacat.Controllers;

import com.example.adoptacat.Entities.Cat;
import com.example.adoptacat.Entities.Owner;
import com.example.adoptacat.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/api/v1/owner",method = RequestMethod.POST)
    public void addOwner(@RequestBody Map<String,String> request){

        ownerService.addOwner(request.get("userid"),request.get("catId"));
    }
    @RequestMapping(value="/api/v1/findowner",method= RequestMethod.POST)
    public Owner findCatOfOwner(@RequestBody Cat cat){
        return ownerService.findCatOfOwner(cat);
    }
}
