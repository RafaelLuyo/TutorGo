package com.platform.tutorgo.advisory.interfaces.rest.resources;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;

import java.util.List;

public record MentorProfileResource(
        Long id,
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        List<String> certificates,

        Mentor mentor
) {
}
