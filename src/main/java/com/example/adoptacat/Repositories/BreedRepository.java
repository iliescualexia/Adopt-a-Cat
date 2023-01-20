package com.example.adoptacat.Repositories;

import com.example.adoptacat.Entities.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed,Long> {
}
