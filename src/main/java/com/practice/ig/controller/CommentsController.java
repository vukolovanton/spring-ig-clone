package com.practice.ig.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.practice.ig.entity.Comments;
import com.practice.ig.service.interfaces.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/comments")
    public Iterable findAllComments() {
        return commentsService.findAll();
    }
}
