package com.platform.tutorgo.advisory.interfaces.rest.resources;

public record CreateStudentProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        Long idStudent
) {
}
