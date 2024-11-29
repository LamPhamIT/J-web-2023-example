package com.lamphamit.springweb.service;

import com.lamphamit.springweb.dto.response.UniversityCodeResponse;
import com.lamphamit.springweb.entity.University;
import com.lamphamit.springweb.mapper.UniversityMapper;
import com.lamphamit.springweb.repository.UniversityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UniversityService {

    UniversityRepository universityRepository;
    UniversityMapper universityMapper;

    public List<UniversityCodeResponse> getAllUniversityCode() {
        List<University> universities = universityRepository.findAll();
        List<UniversityCodeResponse> responses = universities.stream().map(universityMapper::universityToUniversityResponse)
                .toList();
        return responses;
    }

}
