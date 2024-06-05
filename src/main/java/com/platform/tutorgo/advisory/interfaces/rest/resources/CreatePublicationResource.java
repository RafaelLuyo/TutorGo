package com.platform.tutorgo.advisory.interfaces.rest.resources;

import java.util.List;

public record CreatePublicationResource (
        String title,
        String description,
        List<String> image,
        Long mentorProfileId
){
}
