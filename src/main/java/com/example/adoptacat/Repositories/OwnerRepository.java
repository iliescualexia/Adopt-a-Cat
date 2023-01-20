package com.example.adoptacat.Repositories;

import com.example.adoptacat.Entities.Owner;
import com.example.adoptacat.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Owner findByIdOwner(Long id);
}
