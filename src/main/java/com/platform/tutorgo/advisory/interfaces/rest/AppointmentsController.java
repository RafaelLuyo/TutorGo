package com.platform.tutorgo.advisory.interfaces.rest;

import com.platform.tutorgo.advisory.domain.model.commands.CancelAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.ConfirmAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.RejectAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentByIdQuery;
import com.platform.tutorgo.advisory.domain.services.commands.AppointmentCommandService;
import com.platform.tutorgo.advisory.domain.services.queries.AppointmentQueryService;
import com.platform.tutorgo.advisory.interfaces.rest.resources.AppointmentResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateAppointmentResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.AppointmentEntityToResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.CreateAppointmentCommandFromResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/appointments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Appointments", description = "Appointments Management Endpoints")
public class AppointmentsController {
    private final AppointmentCommandService appointmentCommandService;
    private final AppointmentQueryService appointmentQueryService;

    public AppointmentsController(AppointmentCommandService appointmentCommandService, AppointmentQueryService appointmentQueryService) {
        this.appointmentCommandService = appointmentCommandService;
        this.appointmentQueryService = appointmentQueryService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResource>> getAllAppointments() {
        var listAppointments = appointmentQueryService.findAll();
        List<AppointmentResource> appointmentResources = listAppointments.stream()
                .map(AppointmentEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentResources);
    }
    @PostMapping
    public ResponseEntity<AppointmentResource> requestAppointment(@RequestBody CreateAppointmentResource resource) {
        var RequestAppointmentCommand= CreateAppointmentCommandFromResource.resourceToCommand(resource);
        var AppointmentId = appointmentCommandService.updateToAppointmentRequest(RequestAppointmentCommand);
        var getAppointmentByIdQuery = new GetAppointmentByIdQuery(AppointmentId);
        var Appointment = appointmentQueryService.findAppointmentById(getAppointmentByIdQuery);

        var appointmentResource = AppointmentEntityToResource.toResourceFromEntity(Appointment.get());
        return new ResponseEntity<>(appointmentResource, HttpStatus.CREATED);
    }

    @PostMapping("/{appointmentId}/confirmations")
    public ResponseEntity<?> confirmAppointment(@PathVariable Long appointmentId) {
        var confirmAppointmentCommand = new ConfirmAppointmentCommand(appointmentId);
        var confirmedAppointmentId = appointmentCommandService.updateToAppointmentConfirm(confirmAppointmentCommand);
        return ResponseEntity.ok(confirmedAppointmentId);
    }
    @PostMapping("/{appointmentId}/rejections")
    public ResponseEntity<?> rejectAppointment(@PathVariable Long appointmentId) {
        var rejectAppointmentCommand = new RejectAppointmentCommand(appointmentId);
        var rejectAppointmentId = appointmentCommandService.updateToAppointmentReject(rejectAppointmentCommand);
        return ResponseEntity.ok(rejectAppointmentId);
    }
    @PostMapping("/{appointmentId}/cancellations")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long appointmentId) {
        var cancelAppointmentCommand = new CancelAppointmentCommand(appointmentId);
        var cancelAppointmentId = appointmentCommandService.updateToAppointmentCancel(cancelAppointmentCommand);
        return ResponseEntity.ok(cancelAppointmentId);
    }


}
