package com.example.project.repository;

import com.example.project.domain.Discussion;
import com.example.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select d from Discussion d join User u where d.user = u.id")
//    public Discussion joinDiscussionAndUser();


}
