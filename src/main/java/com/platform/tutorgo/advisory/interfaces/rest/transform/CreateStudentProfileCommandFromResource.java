package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentProfileCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateStudentProfileResource;

public class CreateStudentProfileCommandFromResource {
    public static CreateStudentProfileCommand resourceToCommand(CreateStudentProfileResource resource) {
        return new CreateStudentProfileCommand(
                resource.nick(),
                resource.phoneNumber(), // Accede directamente al campo 'phonenumber'
                resource.slogan(),
                resource.userProfilePhoto(),
                resource.idStudent()
        );
    }
}


