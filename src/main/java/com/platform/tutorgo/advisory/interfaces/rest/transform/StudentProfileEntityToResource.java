package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.aggregates.StudentProfile;
import com.platform.tutorgo.advisory.interfaces.rest.resources.StudentProfileResource;

public class StudentProfileEntityToResource {
    public static StudentProfileResource toResourceFromEntity(StudentProfile entity) {
        return new StudentProfileResource(
                entity.getId(),
                entity.getNick(),
                entity.getPhoneNumber(),
                entity.getSlogan(),
                entity.getUserProfilePhoto(),
                entity.getStudent()
        );
    }
}
