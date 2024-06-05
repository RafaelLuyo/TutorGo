package com.platform.tutorgo.advisory.domain.services.commands;


import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import com.platform.tutorgo.advisory.domain.model.commands.CreateMentorProfileCommand;
import com.platform.tutorgo.advisory.domain.model.commands.UpdateMentorProfileCommand;

import java.util.Optional;

public interface MentorProfileCommandService {
    Long createMentorProfile(CreateMentorProfileCommand command);
    Optional<MentorProfile> updateMentorProfileByID(UpdateMentorProfileCommand command);
}
