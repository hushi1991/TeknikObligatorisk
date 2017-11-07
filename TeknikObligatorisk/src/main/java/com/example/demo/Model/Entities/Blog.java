package com.example.demo.Model.Entities;

public class Blog {

    private int id;
    private String post;

    public Blog() {
    }

    public Blog(int id, String post) {
        this.id = id;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
