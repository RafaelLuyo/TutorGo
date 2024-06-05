package com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories;

import com.platform.tutorgo.advisory.domain.model.aggregates.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByMentorId(Long idMentor);
    List<Appointment> findByStudentId(Long idStudent);
}
