package com.example.spring_rest_apis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_rest_apis.dto.CourseDTO;
import com.example.spring_rest_apis.service.CourseService;

@RestController
@RequestMapping("/api/")
public class CourseController {

	private final CourseService courseService;

	private CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@PostMapping("save")
	public ResponseEntity<String> saveCourse(@RequestBody CourseDTO courseDTO) {
		try {
			this.courseService.save(courseDTO);
			return ResponseEntity.ok("New CourseCreated");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Existed with : " + courseDTO.getTitle());
		}
	}

}
