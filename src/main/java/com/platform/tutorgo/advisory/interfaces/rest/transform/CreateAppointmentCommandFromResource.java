package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.RequestAppointmentCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResource {
    public static RequestAppointmentCommand resourceToCommand(CreateAppointmentResource resource){
        return new RequestAppointmentCommand(resource.description(),resource.studentId(),resource.mentorId());
    }
}
