package com.example.project.controller;


import com.example.project.domain.Discussion;
import com.example.project.domain.Movie;
import com.example.project.domain.User;
import com.example.project.service.DiscussionService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/discussion")
public class DiscussionController {

    @Autowired
    DiscussionService discussionService;

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Discussion> discussionAll = discussionService.findAll();
        model.addAttribute("discussionAll", discussionAll);
        return "discussion/list";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        Discussion discussion = new Discussion();
        Movie movie = new Movie();
        model.addAttribute("discussion", discussion);
        model.addAttribute("movie", movie);
        return "discussion/form";
    }

    @PostMapping("/form")
    public String postForm(Model model, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        Discussion discussion = (Discussion) model.getAttribute("discussion");
//        discussion.addUser(user);
//        discussionService.save(discussion);

        return "redirect:/discussion/list";
    }
}
