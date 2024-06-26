package com.platform.tutorgo.security.interfaces.rest.transform;

import com.platform.tutorgo.security.domain.model.commands.SignUpCommand;
import com.platform.tutorgo.security.domain.model.entities.Role;
import com.platform.tutorgo.security.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource signUpResource) {
        var roles = signUpResource.roles() != null ? signUpResource.roles().stream()
                .map(name -> Role.toRoleFromName(name))
                .toList() : new ArrayList<Role>();
        return new SignUpCommand(signUpResource.username(), signUpResource.password(), roles);
    }
}
