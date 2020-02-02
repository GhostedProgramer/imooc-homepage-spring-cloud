package com.imooc.homepage.controller;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.service.ICourseService;
import com.netflix.loadbalancer.RetryRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomepageCourseController {

    private Logger logger = LoggerFactory.getLogger(HomepageCourseController.class);
    private final ICourseService courseService;

    @Autowired
    public HomepageCourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/detail")
    public CourseInfo detail(Long id) {
        logger.info("get course detail");
        return courseService.getCourseInfo(id);
    }

    @GetMapping("/list")
    public List<CourseInfo> list(@RequestBody CourseInfosRequest request) {
        logger.info("get courses list");
        return courseService.getCourseInfos(request);
    }
}
