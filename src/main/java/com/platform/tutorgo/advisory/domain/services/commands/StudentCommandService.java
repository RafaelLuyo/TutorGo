package com.platform.tutorgo.advisory.domain.services.commands;

import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long createStudent(CreateStudentCommand command);
}
