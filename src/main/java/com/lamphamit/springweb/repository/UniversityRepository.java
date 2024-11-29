package com.lamphamit.springweb.repository;

import com.lamphamit.springweb.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, String> {
    University findByUniversityCode(String universityCode);
}
