package com.imooc.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_course")
public class HomepageCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    /**
     * 课程(0)免费,(1)付费
     **/
    @Column(name = "course_type", nullable = false)
    private Integer courseType;

    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public HomepageCourse(String courseName, Integer courseType, String courseIcon, String courseIntro) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    public static HomepageCourse invalid() {
        HomepageCourse homepageCourse = new HomepageCourse("", 0, "", "");
        homepageCourse.setId(-1L);
        return homepageCourse;
    }
}
