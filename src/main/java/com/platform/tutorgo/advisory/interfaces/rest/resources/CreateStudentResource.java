package com.platform.tutorgo.advisory.interfaces.rest.resources;

public record CreateStudentResource(
        String firstName,
        String lastname,
        String email,
        String password,
        String subscription
) {

}
