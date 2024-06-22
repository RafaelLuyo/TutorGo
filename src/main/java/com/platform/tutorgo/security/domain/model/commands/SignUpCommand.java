package com.platform.tutorgo.security.domain.model.commands;

import com.platform.tutorgo.security.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
