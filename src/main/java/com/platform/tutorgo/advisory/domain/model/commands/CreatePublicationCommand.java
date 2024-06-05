package com.platform.tutorgo.advisory.domain.model.commands;

import java.util.List;

public record CreatePublicationCommand(
        String title,
        String description,
        List<String> images,
        Long mentorProfileId
) {
}
