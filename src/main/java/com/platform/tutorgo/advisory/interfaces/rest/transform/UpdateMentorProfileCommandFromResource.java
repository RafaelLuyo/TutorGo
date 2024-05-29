package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.UpdateMentorProfileCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.UpdateMentorProfileResource;

public class UpdateMentorProfileCommandFromResource {
    public static UpdateMentorProfileCommand toCommandFromResource(Long mentorProfileId, UpdateMentorProfileResource resource) {

        return new UpdateMentorProfileCommand(
                mentorProfileId,
                resource.nick(),
                resource.phoneNumber(),
                resource.slogan(),
                resource.userProfilePhoto(),
                resource.certificates()
        );
    }
}
