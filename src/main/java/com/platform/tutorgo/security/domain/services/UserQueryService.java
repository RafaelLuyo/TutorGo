package com.platform.tutorgo.security.domain.services;

import com.platform.tutorgo.security.domain.model.aggregates.User;
import com.platform.tutorgo.security.domain.model.queries.GetAllUsersQuery;
import com.platform.tutorgo.security.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
