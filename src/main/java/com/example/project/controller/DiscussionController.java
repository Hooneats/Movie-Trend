package com.example.project.controller;


import com.example.project.domain.Discussion;
import com.example.project.domain.DiscussionMovie;
import com.example.project.service.form.DiscussionForm;
import com.example.project.service.DiscussionService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
        List<Discussion> discussionAll = discussionService.findAllByIdDesc();
        model.addAttribute("discussionAll", discussionAll);
        return "discussion/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id") Long id, Model model) {
        Discussion discussion = discussionService.findById(id);
        DiscussionForm discussionForm = new DiscussionForm();
        discussionForm.ifNullMovie(discussion.getSubject(), discussion.getContent());
        if (discussion.getDiscussionMovie() != null) {
            discussionForm.existMovie(discussion.getDiscussionMovie().getMovieTitle(), discussion.getDiscussionMovie().getMovieImage());
        }
        model.addAttribute("discussion", discussionForm);
        return "discussion/detail";
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
        Discussion discussion = new Discussion(discussionForm.getSubject(), discussionForm.getContent(),
                new DiscussionMovie(discussionForm.getMovieTitle(),discussionForm.getMovieImage()),new Date());
        discussionService.save(discussion);

        return "redirect:/discussion/list";
    }
}
