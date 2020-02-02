package com.imooc.homepage.service;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.Application;
import com.imooc.homepage.dao.HomepageUserCourseDao;
import com.imooc.homepage.entity.HomepageUser;
import com.imooc.homepage.entity.HomepageUserCourse;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HomePageUserServiceTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private HomepageUserCourseDao userCourseDao;

    //    @Test
    public void create() {
        System.out.println(JSON.toJSONString(userService.create(new CreateUserRequest(
                "小明", "139"
        ))));
    }

    @Test
    public void createUserCourse() {
        HomepageUserCourse course1 = new HomepageUserCourse(
                6L,
                7L
        );
        HomepageUserCourse course2 = new HomepageUserCourse(
                6L,
                6L
        );
        System.out.println(JSON.toJSONString(userCourseDao.saveAll(Arrays.asList(course1, course2))));
    }
}
