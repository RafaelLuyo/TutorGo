package com.platform.tutorgo.advisory.domain.services.commands;

import com.platform.tutorgo.advisory.domain.model.commands.CreateMentorCommand;

public interface MentorCommandService {
    Long createMentor(CreateMentorCommand command);

}
