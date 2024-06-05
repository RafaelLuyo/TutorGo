package com.platform.tutorgo.advisory.domain.model.commands;

public record RequestAppointmentCommand(String description, Long studentId, Long mentorId) {
}
