package com.practice.ig.controller;

import com.practice.ig.entity.Tags;
import com.practice.ig.service.interfaces.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("tags/pagination")
    public @ResponseBody List<Tags> getPaginatedTagsList(@RequestParam("cursor") int cursor, @RequestParam("limit") int limit) {
        return tagsService.paginatedTagsList(cursor, limit);
    }
}
