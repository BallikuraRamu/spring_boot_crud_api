package com.example.spring_rest_apis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_rest_apis.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Optional<Course> findByTitle(String title);
}
