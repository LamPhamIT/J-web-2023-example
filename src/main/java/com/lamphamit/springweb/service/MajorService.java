package com.lamphamit.springweb.service;

import com.lamphamit.springweb.dto.response.MajorCodeResponse;
import com.lamphamit.springweb.entity.Major;
import com.lamphamit.springweb.mapper.MajorMapper;
import com.lamphamit.springweb.repository.MajorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MajorService {
    MajorRepository majorRepository;
    MajorMapper majorMapper;

    public List<MajorCodeResponse> getAllMajorCodes() {
        List<Major> majors = majorRepository.findAll();
        List<MajorCodeResponse> responses =  majors.stream().map(majorMapper::toMajorCodeResponse)
                .toList();
        return responses;
    }
}
