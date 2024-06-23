package com.platform.tutorgo.security.interfaces.rest.transform;

import com.platform.tutorgo.security.domain.model.entities.Role;
import com.platform.tutorgo.security.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
