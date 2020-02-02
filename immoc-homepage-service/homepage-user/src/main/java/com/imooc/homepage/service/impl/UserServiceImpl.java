package com.imooc.homepage.service.impl;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.UserInfo;
import com.imooc.homepage.client.CourseClient;
import com.imooc.homepage.dao.HomepageUserCourseDao;
import com.imooc.homepage.dao.HomepageUserDao;
import com.imooc.homepage.entity.HomepageUser;
import com.imooc.homepage.entity.HomepageUserCourse;
import com.imooc.homepage.service.IUserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private HomepageUserDao homepageUserDao;
    @Autowired
    private HomepageUserCourseDao homepageUserCourseDao;
    @Autowired
    private CourseClient courseClient;

    @Override
    public UserInfo create(CreateUserRequest request) {
        if (!request.valide()) {
            return UserInfo.invalid();
        }
        HomepageUser oldUser = homepageUserDao.findByUsername(request.getUsername());
        if (oldUser != null) {
            return UserInfo.invalid();
        }
        HomepageUser newUser = homepageUserDao.save(new HomepageUser(
                request.getUsername(), request.getEmail()
        ));
        return new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfo detail(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        } else {
            HomepageUser newUser = user.get();
            return new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
        }
    }

    @Override
    public UserCourserInfo getUserCourseInfo(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserCourserInfo.invalid();
        } else {
            HomepageUser newUser = user.get();
            UserInfo userInfo = new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
            List<HomepageUserCourse> userCourses = homepageUserCourseDao.findAllByUserId(userInfo.getId());
            if (CollectionUtils.isEmpty(userCourses)) {
                return new UserCourserInfo(userInfo, Collections.emptyList());
            }
            List<CourseInfo> list = courseClient.list(new CourseInfosRequest(
                    userCourses.stream().map(HomepageUserCourse::getCourseId).collect(Collectors.toList())
            ));
            return new UserCourserInfo(userInfo, list);
        }
    }
}
