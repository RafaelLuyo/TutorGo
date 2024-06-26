package com.platform.tutorgo.advisory.domain.services.queries;

import com.platform.tutorgo.advisory.domain.model.aggregates.Publication;
import com.platform.tutorgo.advisory.domain.model.queries.GetPublicationByIdQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetPublicationByMentorIdQuery;

import java.util.List;
import java.util.Optional;

public interface PublicationQueryService {
    List<Publication> findAllPublications();

    Optional<Publication> findPublicationById(GetPublicationByIdQuery query);

    List<Publication> findPublicationByMentorId(GetPublicationByMentorIdQuery query);
}
