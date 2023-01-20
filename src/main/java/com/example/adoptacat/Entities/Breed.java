package com.example.adoptacat.Entities;

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
@Table(name="breed")
public class Breed {
  @Id
  @GeneratedValue
  private long breedid;
  @Column(name = "breed_name")
  private String breedname;


}
