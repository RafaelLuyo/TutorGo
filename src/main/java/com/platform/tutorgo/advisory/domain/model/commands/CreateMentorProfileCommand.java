package com.platform.tutorgo.advisory.domain.model.commands;

import java.util.List;

public record CreateMentorProfileCommand(
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto,
        List<String> certificates,
        Long mentorId
)
{
}
