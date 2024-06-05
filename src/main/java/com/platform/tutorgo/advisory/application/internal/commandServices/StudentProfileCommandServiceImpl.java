package com.platform.tutorgo.advisory.application.internal.commandServices;


import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.domain.model.aggregates.StudentProfile;
import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentProfileCommand;
import com.platform.tutorgo.advisory.domain.model.commands.DeletePublicationCommand;
import com.platform.tutorgo.advisory.domain.model.commands.UpdateStudentProfileCommand;
import com.platform.tutorgo.advisory.domain.model.valueobjects.UserProfilePhoto;
import com.platform.tutorgo.advisory.domain.services.commands.StudentProfileCommandService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.StudentProfileRepository;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentProfileCommandServiceImpl implements StudentProfileCommandService {
    private final StudentProfileRepository studentProfileRepository;
    private final StudentRepository studentRepository;

    public StudentProfileCommandServiceImpl(StudentProfileRepository studentProfileRepository, StudentRepository studentRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public Long createStudentProfile(CreateStudentProfileCommand command) {
        Optional<Student> student = studentRepository.findById(command.studentId());

        if (student.isPresent()) {
            StudentProfile studentProfile = new StudentProfile(
                    command.nick(),
                    command.phonenumber(),
                    command.slogan(),
                    command.userprofilephoto(),
                    student.get()
            );

            StudentProfile savedProfile = studentProfileRepository.save(studentProfile);
            return savedProfile.getId();
        } else {
            return null;
        }
    }
    @Override
    public Optional<StudentProfile> updateStudentProfileByID(UpdateStudentProfileCommand command) {
        Optional<StudentProfile> existingProfile = studentProfileRepository.findById(command.id());

        if (existingProfile.isPresent()) {
            StudentProfile updatedProfile = existingProfile.get();
            updatedProfile.updateNick(command.nick());
            if (command.phonenumber() != null) {
                updatedProfile.updatePhoneNumber(command.phonenumber());
            }

            if (command.slogan() != null) {
                updatedProfile.updateSlogan(command.slogan());
            }

            if (command.userprofilephoto() != null) {
                updatedProfile.updateUserProfilePhoto(new UserProfilePhoto(command.userprofilephoto()));
            }

            StudentProfile savedProfile = studentProfileRepository.save(updatedProfile);
            return Optional.of(savedProfile);
        } else {
            // Maneja el caso en el que no se encuentra el perfil a actualizar
            return Optional.empty();
        }
    }

    @Override
    public void deletePublication(DeletePublicationCommand deletePublicationCommand) {
        studentProfileRepository.deleteById(deletePublicationCommand.publicationId());
    }
}