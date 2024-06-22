package com.platform.tutorgo.security.interfaces.rest.transform;

import com.platform.tutorgo.security.domain.model.aggregates.User;
import com.platform.tutorgo.security.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
