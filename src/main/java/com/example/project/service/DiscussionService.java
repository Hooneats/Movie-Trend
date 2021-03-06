package com.example.project.service;

import com.example.project.domain.Discussion;
import com.example.project.domain.User;
import com.example.project.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiscussionService {

    @Autowired
    DiscussionRepository discussionRepository;

    public void save(Discussion discussion) {
        discussionRepository.save(discussion);
    }

    public void saveAll(List<Discussion> discussionList) {
        discussionRepository.saveAll(discussionList);
    }

    @Transactional(readOnly = false)
    public List<Discussion> findAllByIdDesc() {
        return discussionRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public Discussion findById(Long id) {
        return discussionRepository.findById(id).orElse(null);
    }
}
