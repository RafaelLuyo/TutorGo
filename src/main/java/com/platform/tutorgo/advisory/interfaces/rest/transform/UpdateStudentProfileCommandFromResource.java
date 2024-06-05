package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.UpdateStudentProfileCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.UpdateStudentProfileResource;

public class UpdateStudentProfileCommandFromResource {
    public static UpdateStudentProfileCommand toCommandFromResource(Long studentProfileId, UpdateStudentProfileResource resource) {

        return new UpdateStudentProfileCommand(
                studentProfileId,
                resource.nick(),
                resource.phoneNumber(),
                resource.slogan(),
                resource.userProfilePhoto()
        );
    }
}
