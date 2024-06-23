package com.platform.tutorgo.security.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}
