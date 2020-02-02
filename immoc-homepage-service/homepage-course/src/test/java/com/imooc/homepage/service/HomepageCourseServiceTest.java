package com.imooc.homepage.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.HomepageCourseApplicationTest;
import com.imooc.homepage.dao.HomepageCourseDao;
import com.imooc.homepage.entity.HomepageCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomepageCourseApplicationTest.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {

    @Autowired
    private HomepageCourseDao homepageCourseDao;
    @Autowired
    private ICourseService courseService;

    //    @Test
    public void create() {
        HomepageCourse course1 = new HomepageCourse(
                "JDK新特性",
                1,
                "https://www.imooc.com",
                "介绍JDK新特性"
        );
        HomepageCourse course2 = new HomepageCourse(
                "SpringCloud",
                1,
                "https://www.imooc.com",
                "SpringCloud各大组件使用"
        );
        homepageCourseDao.saveAll(Arrays.asList(course1, course2));
    }

    @Test
    public void detail() {
        System.out.println(
                JSON.toJSONString(courseService.getCourseInfo(6L))
        );
        System.out.println(
                JSON.toJSONString(courseService.getCourseInfo(8L))
        );
    }

    @Test
    public void list() {
        CourseInfosRequest courseInfosRequest = new CourseInfosRequest();
        courseInfosRequest.setIds(Arrays.asList(6L, 7L));
        System.out.println(JSON.toJSONString(courseService.getCourseInfos(courseInfosRequest)));
    }
}
