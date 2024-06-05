package com.platform.tutorgo.advisory.application.internal.commandservices;

import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentCommand;
import com.platform.tutorgo.advisory.domain.services.commands.StudentCommandService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long createStudent(CreateStudentCommand command) {
        /*var emailAddress = new EmailAddress(command.email());
        studentRepository.findByEmail(emailAddress)
                .map(student -> {
                    throw new IllegalArgumentException("Studdent whit email"+ command.email()+" already exists");
                });*/
        var student = new Student(command.firstname(),command.lastname(),command.email(),command.password());
        studentRepository.save(student);
        return student.getId();
    }
}
