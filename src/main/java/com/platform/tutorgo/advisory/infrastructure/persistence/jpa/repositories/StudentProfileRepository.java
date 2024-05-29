package com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories;


import com.platform.tutorgo.advisory.domain.model.aggregates.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    List<StudentProfile> findByStudentId(Long idStudent);
    //Optional<StudentProfile> findStudentProfilesByPhoneNumber(PhoneNumber phoneNumber);
}
