package com.lamphamit.springweb.service;

import com.lamphamit.springweb.dto.response.StudentResponse;
import com.lamphamit.springweb.entity.Student;
import com.lamphamit.springweb.mapper.StudentMapper;
import com.lamphamit.springweb.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;

    public List<StudentResponse> searchStudents(String keyword) {
        List<Student> students = studentRepository.findByKeyword(keyword);
        return students.stream().map(studentMapper::toStudentResponse).toList();
    }
}
