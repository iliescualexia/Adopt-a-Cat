package com.example.adoptacat.Services;

import com.example.adoptacat.Entities.*;
import com.example.adoptacat.Repositories.CatRepository;
import com.example.adoptacat.Repositories.OwnerRepository;
import com.example.adoptacat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CatRepository catRepository;

    public void addOwner(String userid, String catId) {
        Owner owner=ownerRepository.findByIdOwner(Long.parseLong(userid));
        Cat cat=catRepository.findByCatId(Long.parseLong(catId));
        if(owner!=null){
            owner.getCats().add(cat);
            ownerRepository.save(owner);
        }
        else{
            Owner owner1=new Owner();
            User user=userRepository.findByUserId(Long.parseLong(userid));
            owner1.setIdOwner(user.getUserId());
            owner1.setUser(user);
            owner1.setCats(new ArrayList<Cat>());
            owner1.getCats().add(cat);
            ownerRepository.save(owner1);
        }
    }
    public Owner findCatOfOwner(Cat cat){
        List<Owner> owners=ownerRepository.findAll();
        Owner owner = null;
        for (Owner value : owners) {
            for (int j = 0; j < value.getCats().size(); j++) {
                if (value.getCats().get(j).getCatId()==cat.getCatId()) {
                    owner = value;
                    break;
                }
            }
        }
        return owner;
    }
}
