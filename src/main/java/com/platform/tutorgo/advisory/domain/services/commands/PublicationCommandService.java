package com.platform.tutorgo.advisory.domain.services.commands;

import com.platform.tutorgo.advisory.domain.model.aggregates.Publication;
import com.platform.tutorgo.advisory.domain.model.commands.*;

import java.util.Optional;

public interface PublicationCommandService {
    Long createPublication(CreatePublicationCommand command);

    Optional<Publication> updatePublicationById(UpdatePublicationCommand command);

    void deletePublication(DeletePublicationCommand command);

    Long incrementView(IncrementViewPublicationCommand command);

    Long incrementLike(IncrementedLikePublicationCommand command);

    Long discountLike(IncrementedLikePublicationCommand command);

}
