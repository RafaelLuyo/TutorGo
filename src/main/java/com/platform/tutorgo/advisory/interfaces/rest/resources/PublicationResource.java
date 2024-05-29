package com.platform.tutorgo.advisory.interfaces.rest.resources;

import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;

import java.util.List;

public record PublicationResource(
        Long id,
        String title,
        String description,
        List<String> image,
        Integer views,

        Integer likes,

        MentorProfile mentorProfile
) {
}
