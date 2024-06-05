package com.platform.tutorgo.advisory.interfaces.rest.resources;

import com.platform.tutorgo.advisory.domain.model.aggregates.Student;

public record StudentProfileResource(

        Long id,
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        Student student
) {
}
