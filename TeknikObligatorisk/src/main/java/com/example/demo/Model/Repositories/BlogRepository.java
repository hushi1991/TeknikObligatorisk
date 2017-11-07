package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BlogRepository implements IBlogRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public ArrayList<Blog> readAll() {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM blog");
        ArrayList<Blog> blogs = new ArrayList<>();

        while (sqlRowSet.next()) {
            blogs.add(new Blog(sqlRowSet.getInt("id"), sqlRowSet.getString("post")));
        }

        return blogs;
    }

    public void create(Blog blog){
        jdbc.update("INSERT INTO blog(post) VALUES ('" + blog.getPost() + "')");
    }


}
