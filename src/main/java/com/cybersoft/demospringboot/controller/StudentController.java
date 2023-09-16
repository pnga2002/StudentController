package com.cybersoft.demospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.demospringboot.dto.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
private final List<Student> list =new ArrayList<>();
	
	@PostMapping("/param")
	public ResponseEntity<List<Student>> insertParam(@RequestParam String name, @RequestParam int age ) {
		Student st = new Student();
		st.setAge(age);
		st.setName(name);
		list.add(st);
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	@GetMapping("/variable/{name}/{age}")
	public ResponseEntity<List<Student>> insertVariable(@PathVariable String name, @PathVariable int age ) {
		Student st = new Student();
		st.setAge(age);
		st.setName(name);
		list.add(st);
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	@PostMapping("/body")
	public ResponseEntity<List<Student>> insertBody(@RequestBody Student student ) {
		list.add(student);
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
}
