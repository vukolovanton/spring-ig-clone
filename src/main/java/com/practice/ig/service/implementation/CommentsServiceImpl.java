package com.practice.ig.service.implementation;

import com.practice.ig.service.interfaces.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments findById(int id) {
        Optional<Comments> comment = commentsRepository.findById(id);
        return comment.get();
    }

}
