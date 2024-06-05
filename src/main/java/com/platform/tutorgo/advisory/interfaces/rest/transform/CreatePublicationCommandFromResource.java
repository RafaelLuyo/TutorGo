package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.CreatePublicationCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreatePublicationResource;

public class CreatePublicationCommandFromResource {
    public static CreatePublicationCommand resourceToCommand(CreatePublicationResource resource){
        return new CreatePublicationCommand(resource.title(),resource.description(), resource.image(),resource.mentorProfileId());
    }
}
