package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.aggregates.Appointment;
import com.platform.tutorgo.advisory.interfaces.rest.resources.AppointmentResource;

public class AppointmentEntityToResource {
    public static AppointmentResource toResourceFromEntity(Appointment appointment){
        return new AppointmentResource(appointment.getId(),appointment.getDescription(),appointment.getStatus(),appointment.getMentor(),appointment.getStudent());
    }
}
