package com.ironhack.homework03.repository;


import com.ironhack.homework03.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    Optional<Author> findByName(String name);
}