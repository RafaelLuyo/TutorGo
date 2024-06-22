package com.platform.tutorgo.security.application.internal.queryservices;

import com.platform.tutorgo.security.domain.model.aggregates.User;
import com.platform.tutorgo.security.domain.model.queries.GetAllUsersQuery;
import com.platform.tutorgo.security.domain.model.queries.GetUserByIdQuery;
import com.platform.tutorgo.security.domain.services.UserQueryService;
import com.platform.tutorgo.security.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }
}
