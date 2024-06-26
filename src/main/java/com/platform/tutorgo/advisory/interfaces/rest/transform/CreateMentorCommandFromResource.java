package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.CreateMentorCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateMentorResource;

public class CreateMentorCommandFromResource {
    public static CreateMentorCommand resourceToCommand(CreateMentorResource resource){
        return new CreateMentorCommand(resource.subscription(),resource.idStudent());
    }
}
