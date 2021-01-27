package com.practice.ig.controller;

import com.practice.ig.entity.Tags;
import com.practice.ig.service.interfaces.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagsController {
    private TagsService tagsService;
    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping("/tags")
    public List<Tags> findAllTags() {
        return tagsService.findAll();
    }

    @GetMapping("/tags/{tagId}")
    public Tags findTagById(@PathVariable int tagId) {
        return tagsService.findTagById(tagId);
    }
}
