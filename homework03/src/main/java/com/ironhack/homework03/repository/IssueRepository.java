package com.ironhack.homework03.repository;

import com.ironhack.homework03.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
}
