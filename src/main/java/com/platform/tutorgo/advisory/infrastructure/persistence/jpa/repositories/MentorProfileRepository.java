package com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories;


import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorProfileRepository extends JpaRepository<MentorProfile, Long> {
    List<MentorProfile> findByMentorId(Long idMentor);
    //Optional<MentorProfile> findMentorProfilesByPhoneNumber(PhoneNumber phoneNumber);
}
