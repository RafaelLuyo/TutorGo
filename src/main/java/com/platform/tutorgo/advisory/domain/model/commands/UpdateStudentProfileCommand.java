package com.platform.tutorgo.advisory.domain.model.commands;

public record UpdateStudentProfileCommand(
        Long id,
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto
) {
}
