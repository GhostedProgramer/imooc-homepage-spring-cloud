package com.imooc.homepage.client;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "eureka-client-homepage-course",
        fallback = CourseClientHystrix.class)
public interface CourseClient {

    @GetMapping("/homepage-course/detail")
    CourseInfo detail(Long id);

    @GetMapping("/homepage-course/list")
    List<CourseInfo> list(@RequestBody CourseInfosRequest request);
}
