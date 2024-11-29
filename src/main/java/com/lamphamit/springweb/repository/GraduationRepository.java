package com.lamphamit.springweb.repository;

import com.lamphamit.springweb.entity.Graduation;
import com.lamphamit.springweb.entity.GraduationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduationRepository extends JpaRepository<Graduation, GraduationKey> {
}
