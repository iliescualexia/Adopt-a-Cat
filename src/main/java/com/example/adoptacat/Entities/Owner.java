package com.example.adoptacat.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    private long idOwner;
    @OneToOne(targetEntity = User.class)
    private User user;
    @OneToMany(targetEntity = Cat.class)
    private List<Cat> cats;

}