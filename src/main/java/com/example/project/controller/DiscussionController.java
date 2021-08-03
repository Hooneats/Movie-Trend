package com.example.project.controller;


import com.example.project.domain.Discussion;
import com.example.project.domain.Movie;
import com.example.project.domain.User;
import com.example.project.form.DiscussionForm;
import com.example.project.service.DiscussionService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
            model.addAttribute("discussionForm", new DiscussionForm());
        return "discussion/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid DiscussionForm discussionForm , BindingResult result) {
//        User user = (User) session.getAttribute("user");
//        Discussion discussion = (Discussion) model.getAttribute("discussion");
//        discussion.addUser(user);
//        discussionService.save(discussion);
        if (result.hasErrors()) {
            return "discussion/form";
        }
        System.out.println(discussionForm.toString());


        return "redirect:/discussion/list";
    }
}
