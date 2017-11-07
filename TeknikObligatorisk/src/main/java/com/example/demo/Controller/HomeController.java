package com.example.demo.Controller;

import com.example.demo.Model.Entities.Blog;
import com.example.demo.Model.Entities.User;
import com.example.demo.Model.Repositories.BlogRepository;
import com.example.demo.Model.Repositories.IBlogRepository;
import com.example.demo.Model.Repositories.IUserRepository;
import com.example.demo.Model.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Blog> blogs = new ArrayList<>();

    @Autowired
    IUserRepository userRepo = new UserRepository();

    @Autowired
    IBlogRepository blogRepo = new BlogRepository();

    @RequestMapping(value = {"","/","index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Blog blog, Model model) {
        if(userRepo.login(user.getUsername(), user.getPassword()) != null) {
            User u = userRepo.login(user.getUsername(), user.getPassword());
            if(u.isAdmin() == true) {
                model.addAttribute("blog", new Blog());
                return "admin";
            }

            blogs = blogRepo.readAll();
            model.addAttribute("b", blogs);
            return "hjem";
        }

        return "login";
    }

    @PostMapping("/admin")
    public String admin(@ModelAttribute Blog blog, Model model){
        blogRepo.create(blog);
        System.out.println(blog.getPost());
        blogs = blogRepo.readAll();
        model.addAttribute("b", blogs);
        return "hjem";
    }

    /*@RequestMapping(value = {"hjem"}, method = RequestMethod.GET)
    public String hjem(Model model) {
        blogs = blogRepo.readAll();
        model.addAttribute("b", blogs);
        return "hjem";
    }*/




}
