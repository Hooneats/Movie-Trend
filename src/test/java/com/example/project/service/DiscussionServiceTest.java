package com.example.project.service;

import com.example.project.domain.Discussion;
import com.example.project.domain.Movie;
import com.example.project.domain.User;
import com.example.project.repository.DiscussionRepository;
import com.example.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class DiscussionServiceTest {

    @Autowired
    DiscussionService discussionService;

    @Autowired
    DiscussionRepository discussionRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 엔티티테스트() {

    }




}