package com.platform.tutorgo.advisory.domain.services.queries;


import com.platform.tutorgo.advisory.domain.model.aggregates.StudentProfile;
import com.platform.tutorgo.advisory.domain.model.queries.GetStudentProfileByStudentIdQuery;

import java.util.List;
import java.util.Optional;

public interface StudentProfileQueryService {
    Optional<StudentProfile> findStudentProfileByStudentId(GetStudentProfileByStudentIdQuery query);
    List<StudentProfile> findAllStudentProfiles();
}
