package com.lamphamit.springweb.service;

import com.lamphamit.springweb.dto.request.CreateGraduationRequest;
import com.lamphamit.springweb.entity.*;
import com.lamphamit.springweb.mapper.GraduationMapper;
import com.lamphamit.springweb.mapper.StudentMapper;
import com.lamphamit.springweb.repository.GraduationRepository;
import com.lamphamit.springweb.repository.MajorRepository;
import com.lamphamit.springweb.repository.StudentRepository;
import com.lamphamit.springweb.repository.UniversityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GraduationService {
    GraduationRepository graduationRepository;
    StudentRepository studentRepository;
    GraduationMapper  graduationMapper;
    StudentMapper studentMapper;
    MajorRepository majorRepository;
    UniversityRepository universityRepository;

    @Transactional
    public boolean saveGraduation(CreateGraduationRequest createGraduationRequest) throws RuntimeException {
        Graduation graduation = graduationMapper.toGraduationByCreateGraduationRequest(createGraduationRequest);
        Student student = studentMapper.toStudentByCreateGraduationRequest(createGraduationRequest);
        student = studentRepository.save(student);
        Major major = majorRepository.findMajorByMajorCode(createGraduationRequest.getMajorCode());
        University university = universityRepository.findByUniversityCode(createGraduationRequest.getUniversityCode());
        GraduationKey graduationKey = new GraduationKey(major.getMajorCode(), student.getIdentityCode(), university.getUniversityCode());
        graduation.setId(graduationKey);
        graduation.setStudent(student);
        graduation.setMajor(major);
        graduation.setUniversity(university);
        graduation = graduationRepository.save(graduation);
        if(graduation == null || student == null) {
            throw new RuntimeException("Error saving graduation");
        }
        return true;
    }
}
