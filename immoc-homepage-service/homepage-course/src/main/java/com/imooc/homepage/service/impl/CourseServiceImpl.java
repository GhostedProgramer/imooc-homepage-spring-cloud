package com.imooc.homepage.service.impl;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.dao.HomepageCourseDao;
import com.imooc.homepage.entity.HomepageCourse;
import com.imooc.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private HomepageCourseDao homepageCourseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        return trans(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }
        List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());
        return courses.stream().map(this::trans).collect(Collectors.toList());
    }

    private CourseInfo trans(HomepageCourse course) {
        return CourseInfo.builder()
                .id(course.getId())
                .courseIcon(course.getCourseIcon())
                .courseName(course.getCourseName())
                .courseIntro(course.getCourseIntro())
                .courseType(course.getCourseType() == 0 ? "免费课程" : "收费课程")
                .build();
    }
}
