package com.platform.tutorgo.advisory.application.internal.commandServices;

import com.platform.tutorgo.advisory.domain.model.aggregates.Appointment;
import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.domain.model.commands.CancelAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.ConfirmAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.RejectAppointmentCommand;
import com.platform.tutorgo.advisory.domain.model.commands.RequestAppointmentCommand;
import com.platform.tutorgo.advisory.domain.services.commands.AppointmentCommandService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.AppointmentRepository;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentCommandServiceImpl implements AppointmentCommandService {

    private final MentorRepository mentorRepository;
    private final StudentRepository studentRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentCommandServiceImpl(MentorRepository mentorRepository, StudentRepository studentRepository, AppointmentRepository appointmentRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Long updateToAppointmentRequest(RequestAppointmentCommand command) {
        Student student = studentRepository.findById(command.studentId())
                .orElseThrow();
        Mentor mentor = mentorRepository.findById(command.mentorId())
                .orElseThrow();
        Appointment appointment = new Appointment(command.description(),student,mentor);
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

    @Override
    public Long updateToAppointmentReject(RejectAppointmentCommand command) {
        appointmentRepository.findById(command.appointmentId())
                .map(appointment -> {
                    appointment.reject();
                    appointmentRepository.save(appointment);
                    return appointment.getId();
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return null;
    }

    @Override
    public Long updateToAppointmentConfirm(ConfirmAppointmentCommand command) {
        appointmentRepository.findById(command.appointmentId())
                .map(appointment -> {
                    appointment.confirm();
                    appointmentRepository.save(appointment);
                    return appointment.getId();
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return null;
    }

    @Override
    public Long updateToAppointmentCancel(CancelAppointmentCommand command) {
        appointmentRepository.findById(command.appointmentId())
                .map(appointment -> {
                    appointment.cancel();
                    appointmentRepository.save(appointment);
                    return appointment.getId();
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return null;
    }
}
