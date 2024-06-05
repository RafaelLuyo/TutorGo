package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity){
        return new StudentResource(entity.getId(),entity.getStudentName(),entity.getEmailAddress(),entity.getPassword());
    }
}
