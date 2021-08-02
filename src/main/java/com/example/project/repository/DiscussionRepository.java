package com.example.project.repository;

import com.example.project.domain.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DiscussionRepository extends JpaRepository<Discussion, Long> {


}
