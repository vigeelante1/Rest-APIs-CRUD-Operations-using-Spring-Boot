package com.springrest.RestApis.services;

import com.springrest.RestApis.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course deleteCourse(long courseId);
    public Course updateCourse(Course course);
}
