package com.platform.tutorgo.advisory.interfaces.rest.resources;

import com.platform.tutorgo.advisory.domain.model.aggregates.Student;

public record MentorResource(
        Long id,

        Student idStudent
) {


}
