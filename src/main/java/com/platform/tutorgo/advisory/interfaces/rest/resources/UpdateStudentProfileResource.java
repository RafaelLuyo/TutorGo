package com.platform.tutorgo.advisory.interfaces.rest.resources;

public record UpdateStudentProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
       String userProfilePhoto
) {
}
