package com.lamphamit.springweb.mapper;

import com.lamphamit.springweb.dto.request.CreateGraduationRequest;
import com.lamphamit.springweb.dto.response.StudentResponse;
import com.lamphamit.springweb.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudentByCreateGraduationRequest(CreateGraduationRequest createGraduationRequest);
    StudentResponse toStudentResponse(Student student);
}
