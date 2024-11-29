package com.lamphamit.springweb.repository;

import com.lamphamit.springweb.dto.response.StudentJobInfoResponse;
import com.lamphamit.springweb.entity.Job;
import com.lamphamit.springweb.entity.JobKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, JobKey> {
    @Query(value = "SELECT s.identity_code AS identityCode," +
            " s.full_name AS fullName," +
            " s.email AS email," +
            " g.major_code AS majorGraduationCode," +
            " g.university_code AS universityCode," +
            " j.major_code AS majorWorkedCode," +
            " j.company_name AS companyName," +
            " j.duration_time AS durationTime" +
            " FROM student s " +
            "JOIN graduation g ON s.identity_code = g.identity_code " +
            "JOIN job as j ON s.identity_code = j.identity_code " +
            " WHERE s.full_name LIKE %:keyword% " +
            "OR s.identity_code LIKE %:keyword% " +
            "OR j.company_name LIKE %:keyword%",
            nativeQuery = true)
    List<Object[]> findStudentJobInfo(@Param("keyword") String keyword);
}
