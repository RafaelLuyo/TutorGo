package com.platform.tutorgo.advisory.domain.model.queries;

import com.platform.tutorgo.advisory.domain.model.valueobjects.EmailAddress;

public record GetStudentByEmailQuery(EmailAddress emailAddress) {

}
