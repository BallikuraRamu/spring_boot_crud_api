package com.example.spring_rest_apis.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.spring_rest_apis.dto.CourseDTO;
import com.example.spring_rest_apis.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper{

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    // Map entity to DTO
    CourseDTO courseToCourseDTO(Course course);

    // Map DTO to entity
    Course courseDTOToCourse(CourseDTO courseDTO);

}
