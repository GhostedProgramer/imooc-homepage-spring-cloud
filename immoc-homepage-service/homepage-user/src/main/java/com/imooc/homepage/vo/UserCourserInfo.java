package com.imooc.homepage.vo;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.UserInfo;

import java.util.Collections;
import java.util.List;

public class UserCourserInfo {

    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public UserCourserInfo invalid() {
        return new UserCourserInfo(
                UserInfo.invalid(),
                Collections.emptyList()
        );
    }

    public UserCourserInfo() {
    }

    public UserCourserInfo(UserInfo userInfo, List<CourseInfo> courseInfos) {
        this.userInfo = userInfo;
        this.courseInfos = courseInfos;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public void setCourseInfos(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }
}
