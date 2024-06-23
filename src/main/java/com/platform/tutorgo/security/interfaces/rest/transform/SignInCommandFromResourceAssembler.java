package com.platform.tutorgo.security.interfaces.rest.transform;

import com.platform.tutorgo.security.domain.model.commands.SignInCommand;
import com.platform.tutorgo.security.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
