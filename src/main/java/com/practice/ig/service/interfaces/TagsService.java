package com.practice.ig.service.interfaces;

import com.practice.ig.entity.Tags;

import java.util.List;

public interface TagsService {
    public List<Tags> findAll();
    public Tags findTagById(int id);
}
