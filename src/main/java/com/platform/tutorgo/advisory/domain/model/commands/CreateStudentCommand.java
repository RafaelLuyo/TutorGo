package com.platform.tutorgo.advisory.domain.model.commands;


public record CreateStudentCommand(String firstname, String lastname, String email, String password,String subscription) {
}
