package com.platform.tutorgo.advisory.application.internal.commandServices;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.domain.model.commands.CreateMentorCommand;
import com.platform.tutorgo.advisory.domain.services.commands.MentorCommandService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class MentorCommandServiceImpl implements MentorCommandService {

    private final MentorRepository mentorRepository;
    private final StudentRepository studentRepository;

    public MentorCommandServiceImpl(MentorRepository mentorRepository, StudentRepository studentRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Long createMentor(CreateMentorCommand command) {
        Student student = studentRepository.findById(command.studentId()).orElseThrow();;
        var Mentor = new Mentor(student);
        mentorRepository.save(Mentor);
        return Mentor.getId();
    }

}
