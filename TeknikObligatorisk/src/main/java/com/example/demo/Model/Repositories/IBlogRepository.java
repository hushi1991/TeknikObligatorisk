package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Blog;

import java.util.ArrayList;

public interface IBlogRepository {

    public ArrayList<Blog> readAll();

    public void create(Blog blog);
}

