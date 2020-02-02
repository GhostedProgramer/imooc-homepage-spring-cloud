package com.imooc.homepage.service;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;

import java.util.List;

public interface ICourseService {

    CourseInfo getCourseInfo(Long id);

    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
