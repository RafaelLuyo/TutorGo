package com.platform.tutorgo.advisory.interfaces.rest;

import com.platform.tutorgo.advisory.domain.model.queries.GetAppointmentsByMentorId;
import com.platform.tutorgo.advisory.domain.services.queries.AppointmentQueryService;
import com.platform.tutorgo.advisory.interfaces.rest.resources.AppointmentResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.AppointmentEntityToResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/mentors/{mentorId}/appointments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Mentors")
public class MentorAppointmentsController {
    private final AppointmentQueryService appointmentQueryService ;

    public MentorAppointmentsController(AppointmentQueryService appointmentCommandService) {
        this.appointmentQueryService = appointmentCommandService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResource>> getAppointmentsByIdMentor(@PathVariable Long mentorId) {
        var getAppointmentByMentorId = new GetAppointmentsByMentorId(mentorId);
        var listAppointments=appointmentQueryService.findAppointmentsByMentorId(getAppointmentByMentorId);


        List<AppointmentResource> appointmentResources = listAppointments.stream()
                .map(AppointmentEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentResources);
    }
}
