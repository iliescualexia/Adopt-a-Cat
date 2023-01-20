package com.example.adoptacat.Entities;

import com.example.adoptacat.Repositories.BreedRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
  @Id
  @GeneratedValue
  private long catId;
  private String name;
  @JoinColumn(name="breedid",referencedColumnName = "breedid")
  private long breedid;
  private long age;
  @JoinColumn(name="idfood",referencedColumnName = "idfood")
  private long idfood;

}
