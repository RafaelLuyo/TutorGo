package com.platform.tutorgo.advisory.domain.model.commands;

public record CreateStudentProfileCommand(
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto,
        Long studentId
)
{
}
