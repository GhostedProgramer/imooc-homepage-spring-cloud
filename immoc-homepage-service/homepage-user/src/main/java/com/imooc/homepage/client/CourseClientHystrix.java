package com.imooc.homepage.client;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CourseClientHystrix implements CourseClient {
    @Override
    public CourseInfo detail(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> list(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
