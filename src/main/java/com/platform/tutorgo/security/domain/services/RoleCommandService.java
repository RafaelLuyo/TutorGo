package com.platform.tutorgo.security.domain.services;

import com.platform.tutorgo.security.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
