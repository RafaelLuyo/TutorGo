package com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories;

import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Ya contiene el CRUD básico de una tabla

    Optional<Student> findByEmail(EmailAddress emailAddress);

}
