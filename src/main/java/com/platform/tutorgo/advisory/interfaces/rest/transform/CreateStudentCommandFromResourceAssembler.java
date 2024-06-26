package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource){
        return new CreateStudentCommand(
                resource.firstName(),
                resource.lastname(),
                resource.email(),
                resource.password()
               );
    }
}
