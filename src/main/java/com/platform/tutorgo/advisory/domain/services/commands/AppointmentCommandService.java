package com.platform.tutorgo.advisory.domain.services.commands;

import com.platform.tutorgo.advisory.domain.model.commands.CancelAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.ConfirmAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.RejectAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.RequestAppointmentCommand;

public interface AppointmentCommandService {
    Long updateToAppointmentRequest(RequestAppointmentCommand command);
    Long updateToAppointmentReject(RejectAppointmentCommand command);
    Long updateToAppointmentConfirm(ConfirmAppointmentCommand command);
    Long updateToAppointmentCancel(CancelAppointmentCommand command);

}
