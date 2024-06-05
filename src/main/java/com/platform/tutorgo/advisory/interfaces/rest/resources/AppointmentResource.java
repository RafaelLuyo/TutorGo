package com.platform.tutorgo.advisory.interfaces.rest.resources;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import com.platform.tutorgo.advisory.domain.model.aggregates.Student;

public record AppointmentResource(
        Long appointmentId,

        String description,

        String status,

        Mentor mentor,
        Student student
) {
}
