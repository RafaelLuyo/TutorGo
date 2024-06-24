package com.platform.tutorgo.advisory.interfaces.rest.resources;

public record StudentResource(
        Long id,
        String fullName,
        String email,
        String password,
        String subscription
) {

}
