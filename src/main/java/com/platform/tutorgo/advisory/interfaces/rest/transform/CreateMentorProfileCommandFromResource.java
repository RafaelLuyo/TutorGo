package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.CreateMentorProfileCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateMentorProfileResource;

public class CreateMentorProfileCommandFromResource {
    public static CreateMentorProfileCommand resourceToCommand(CreateMentorProfileResource resource) {
        return new CreateMentorProfileCommand(
                resource.nick(),
                resource.phoneNumber(), // Accede directamente al campo 'phonenumber'
                resource.slogan(),
                resource.userProfilePhoto(),
                resource.certificates(),
                resource.idMentor()
        );
    }
}


