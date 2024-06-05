package com.platform.tutorgo.advisory.domain.services.queries;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorByIdQuery;

import java.util.Optional;

public interface MentorQueryService {
    Optional<Mentor> findMentorById(GetMentorByIdQuery query);
}
