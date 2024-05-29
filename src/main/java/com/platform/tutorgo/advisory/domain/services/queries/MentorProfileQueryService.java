package com.platform.tutorgo.advisory.domain.services.queries;


import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorProfileByIdQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorProfileByMentorIdQuery;

import java.util.List;
import java.util.Optional;

public interface MentorProfileQueryService {


    Optional<MentorProfile> findMentorProfileByMentorId(GetMentorProfileByMentorIdQuery query);
    Optional<MentorProfile> findMentorProfileById(GetMentorProfileByIdQuery query);

    List<MentorProfile> findAllMentorProfiles();
}
