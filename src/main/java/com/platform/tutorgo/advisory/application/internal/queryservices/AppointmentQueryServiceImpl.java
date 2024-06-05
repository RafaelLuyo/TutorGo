package com.platform.tutorgo.advisory.application.internal.queryservices;

import com.platform.tutorgo.advisory.domain.model.aggregates.Appointment;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentByIdQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentByStudentId;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentsByMentorId;
import com.platform.tutorgo.advisory.domain.services.queries.AppointmentQueryService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentQueryServiceImpl implements AppointmentQueryService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentQueryServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Optional<Appointment> findAppointmentById(GetAppointmentByIdQuery query) {
        return this.appointmentRepository.findById(query.idAppointment());
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findAppointmentsByStudentId(GetAppointmentByStudentId query) {
        return this.appointmentRepository.findByStudentId(query.studentId());
    }

    @Override
    public List<Appointment> findAppointmentsByMentorId(GetAppointmentsByMentorId query) {
        return this.appointmentRepository.findByMentorId(query.mentorId());
    }

}
