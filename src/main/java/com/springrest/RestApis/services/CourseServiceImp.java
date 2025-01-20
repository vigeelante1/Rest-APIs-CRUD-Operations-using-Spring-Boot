package com.springrest.RestApis.services;

import com.springrest.RestApis.dao.CourseDao;
import com.springrest.RestApis.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService{

    @Autowired
    private CourseDao courseDao;

//    List<Course> list;

    public CourseServiceImp(){

//        list = new ArrayList<>();
//        list.add(new Course(00001 , "Java Course" , "Core Java Tutorial"));
//        list.add(new Course(00002 , "SpringBoot" , "SpringBoot Tutorial"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {

//        Course c = null;
//
//        for (Course course: list){
//
//            if (course.getId() == courseId){
//
//                c = course;
//                break;
//
//            }
//        }
//
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {

        courseDao.save(course);
//       list.add(course);
       return course;
    }

    @Override
    public Course deleteCourse(long courseId) {

        Course entity = courseDao.getOne(courseId);
        courseDao.delete(entity);
//        Course c = null;
//
//        for (Course course: list){
//
//            if (course.getId() == courseId){
//
//                list.remove(course);
//                break;
//            }
//        }
        return entity;
    }

    @Override
    public Course updateCourse(Course course) {

        courseDao.save(course);

//        list.forEach(e -> {
//              if (e.getId() == course.getId()) {
//
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            } });

        return course;
    }
}
