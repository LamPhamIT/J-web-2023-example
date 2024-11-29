package com.lamphamit.springweb.repository;

import com.lamphamit.springweb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT * FROM student  WHERE " +
            "identity_code LIKE %:keyword%"  +
            " OR full_name LIKE %:keyword%" +
            " OR address LIKE %:keyword%", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);


}
