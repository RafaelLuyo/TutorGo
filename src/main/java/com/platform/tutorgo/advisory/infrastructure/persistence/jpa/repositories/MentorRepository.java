package com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor,Long> {


}
