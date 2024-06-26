package com.platform.tutorgo.security.domain.services;

import com.platform.tutorgo.security.domain.model.aggregates.User;
import com.platform.tutorgo.security.domain.model.commands.SignInCommand;
import com.platform.tutorgo.security.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
