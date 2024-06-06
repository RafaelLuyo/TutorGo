package com.platform.tutorgo.advisory.interfaces.rest.resources;

import java.util.List;

public record CreateMentorProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        List<String> certificates,
        Long idMentor
) {
}
