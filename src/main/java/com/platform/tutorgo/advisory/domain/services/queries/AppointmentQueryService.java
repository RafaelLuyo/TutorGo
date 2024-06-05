package com.platform.tutorgo.advisory.domain.services.queries;

import com.platform.tutorgo.advisory.domain.model.aggregates.Appointment;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentByIdQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentByStudentId;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentsByMentorId;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    Optional<Appointment> findAppointmentById(GetAppointmentByIdQuery query);

    List<Appointment> findAll();

    List<Appointment> findAppointmentsByStudentId(GetAppointmentByStudentId query);

    List<Appointment> findAppointmentsByMentorId(GetAppointmentsByMentorId query);
}
