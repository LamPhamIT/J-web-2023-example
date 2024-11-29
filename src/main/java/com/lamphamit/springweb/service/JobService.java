package com.lamphamit.springweb.service;

import com.lamphamit.springweb.dto.response.StudentJobInfoResponse;
import com.lamphamit.springweb.repository.JobRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobService {
    JobRepository jobRepository;
    public List<StudentJobInfoResponse> searchStudentJob(String keyword) {
        List<Object[]> result = jobRepository.findStudentJobInfo(keyword);
        List<StudentJobInfoResponse> studentJobInfoResponses = result.stream().map(
                (o) -> new StudentJobInfoResponse(
                        (String) o[0],
                        (String) o[1],
                        (String) o[2],
                        (String) o[3],
                        (String) o[4],
                        (String) o[5],
                        (String) o[6],
                        (String) o[7]
                )
        ).toList();
        return studentJobInfoResponses;
    }
}
