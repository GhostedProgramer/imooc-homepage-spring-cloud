package com.imooc.homepage.service;

import com.imooc.homepage.UserInfo;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourserInfo;

public interface IUserService {
    UserInfo create(CreateUserRequest request);

    UserInfo detail(Long id);

    UserCourserInfo getUserCourseInfo(Long id);
}
