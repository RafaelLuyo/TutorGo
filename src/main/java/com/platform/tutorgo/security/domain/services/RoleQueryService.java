package com.platform.tutorgo.security.domain.services;

import com.platform.tutorgo.security.domain.model.entities.Role;
import com.platform.tutorgo.security.domain.model.queries.GetAllRolesQuery;
import com.platform.tutorgo.security.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
