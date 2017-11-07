package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.User;

import java.util.ArrayList;

public interface IUserRepository {

    public ArrayList<User> readAll();

    public User login(String username, String password);

}
