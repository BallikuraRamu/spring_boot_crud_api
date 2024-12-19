package com.example.spring_rest_apis.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring_rest_apis.dto.CourseDTO;
import com.example.spring_rest_apis.entity.Course;
import com.example.spring_rest_apis.mapper.CourseMapper;
import com.example.spring_rest_apis.repository.CourseRepository;
import com.example.spring_rest_apis.service.CourseService;

import jakarta.persistence.EntityExistsException;

@Service
public class CourseServiceImpl implements CourseService {

	private final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final CourseRepository courseRepository;
	private final CourseMapper courseMapper;

	private CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
		super();
		this.courseRepository = courseRepository;
		this.courseMapper = courseMapper;
	}

	@Override
	public CourseDTO save(CourseDTO courseDTO) {
		logger.info("Service request to {} ", courseDTO);
		Course entity = courseMapper.courseDTOToCourse(courseDTO);
		Optional<Course> c = courseRepository.findByTitle(entity.getTitle()); // This returns Optional<Course>
		if (c.isPresent()) {
			logger.error("Course has already existed {}", courseDTO.getTitle());
			throw new EntityExistsException();
		}
		courseRepository.save(entity);
		logger.info("New Course Created {} ", entity);
		return courseDTO;
	}

}
