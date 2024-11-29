package com.lamphamit.springweb.repository;

import com.lamphamit.springweb.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends JpaRepository<Major, String> {
    Major findMajorByMajorCode(String majorCode);
}
