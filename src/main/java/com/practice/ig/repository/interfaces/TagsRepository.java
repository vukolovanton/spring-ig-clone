package com.practice.ig.repository.interfaces;

import com.practice.ig.entity.Tags;

import java.util.List;

public interface TagsRepository {
    public List<Tags> findAll();
    public Tags findTagById(int id);
}
