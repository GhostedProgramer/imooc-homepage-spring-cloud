package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.UserInfo;
import com.imooc.homepage.service.IUserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourserInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/homepage-user")
public class HomepageUserController {
    private Logger logger = LoggerFactory.getLogger(HomepageUserController.class);
    @Autowired
    private IUserService userService;

    @PostMapping
    public UserInfo create(@RequestBody CreateUserRequest request) {
        logger.info("<homepage-user> create -> {}", JSON.toJSONString(request));
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public UserInfo detail(@PathVariable Long id) {
        logger.info("<homepage-user> detail -> {}", id);
        return userService.detail(id);
    }

    @GetMapping("/courseInfo/{id}")
    public UserCourserInfo getUserCourseInfo(@PathVariable Long id) {
        logger.info("<homepage-user> user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
