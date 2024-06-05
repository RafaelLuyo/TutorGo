package com.platform.tutorgo.advisory.domain.services.commands;


import com.platform.tutorgo.advisory.domain.model.aggregates.StudentProfile;
import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentProfileCommand;
import com.platform.tutorgo.advisory.domain.model.commands.DeletePublicationCommand;
import com.platform.tutorgo.advisory.domain.model.commands.UpdateStudentProfileCommand;

import java.util.Optional;

public interface StudentProfileCommandService {
    Long createStudentProfile(CreateStudentProfileCommand command);

    Optional<StudentProfile> updateStudentProfileByID(UpdateStudentProfileCommand command);


    void deletePublication(DeletePublicationCommand deletePublicationCommand);
}
