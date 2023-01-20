package com.example.adoptacat.Repositories;

import com.example.adoptacat.Entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter,Long> {
    Shelter findByShelterid(Long id);
}
