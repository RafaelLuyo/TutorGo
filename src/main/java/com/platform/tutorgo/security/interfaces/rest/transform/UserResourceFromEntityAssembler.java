package com.platform.tutorgo.security.interfaces.rest.transform;

import com.platform.tutorgo.security.domain.model.aggregates.User;
import com.platform.tutorgo.security.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(role -> role.getName().name()).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
