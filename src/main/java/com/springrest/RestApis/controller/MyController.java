package com.springrest.RestApis.controller;
import com.springrest.RestApis.entities.Course;
import com.springrest.RestApis.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
     private CourseService courseService;

    // get request to land to home page;

    @GetMapping("/home")
    public String home(){

        return "Welcome to the home/landing pages of yours.";
    }

    // get request to get all the courses;

    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){

        return this.courseService.getCourse (Long.parseLong(courseId));

    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){

        return this.courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){

        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);

        }

        catch(Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){

        return this.courseService.updateCourse(course);
    }
}
