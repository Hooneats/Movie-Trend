package com.example.project.init;

import com.example.project.domain.Discussion;
import com.example.project.domain.Movie;
import com.example.project.domain.User;
import com.example.project.service.DiscussionService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Initializer {

    @Autowired
    UserService userService;

    @Autowired
    DiscussionService discussionService;

    @PostConstruct
    public void init() {
        List<User> userList = new ArrayList<>();
        User user1 = new User("아아", "123","kmh@naver.com", new Date());
        User user2 = new User("까페", "123","mmm@naver.com", new Date());
        User user3 = new User("라떼", "123","hhh@naver.com", new Date());
        User user4 = new User("여름", "123","kkk@naver.com", new Date());
        User user5 = new User("얼음", "123","aaa@naver.com", new Date());
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userService.saveAll(userList);

        Movie movie1 = new Movie("블랙위도우","/wwemzKWzjKYJFfCeiB57q3r4Bcm.png", new Date());
        Movie movie2 = new Movie("재밌다", "/qAZ0pzat24kLdO3o8ejmbLxyOac.jpg", new Date());

        List<Discussion> discussionList = new ArrayList<>();
        Discussion discussion1 = new Discussion("이거봤어?", "완전재밌어", movie1, new Date());
        Discussion discussion2 = new Discussion("이것도?", "완전재밌어", movie2, new Date());
        Discussion discussion3 = new Discussion("이것도?", "완전재밌어", new Date());
//        discussion1.addUser(user1);
//        discussion2.addUser(user2);
//        discussion3.addUser(user3);
        discussionList.add(discussion1);
        discussionList.add(discussion2);
        discussionList.add(discussion3);
        discussionService.saveAll(discussionList);

    }

}
