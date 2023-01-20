package com.example.adoptacat.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Utilizator")
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String email;
    private String password;
    private String phoneNumber;
    private String name;

}
