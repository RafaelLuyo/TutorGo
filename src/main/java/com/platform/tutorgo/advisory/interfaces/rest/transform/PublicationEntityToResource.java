package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.aggregates.Publication;
import com.platform.tutorgo.advisory.interfaces.rest.resources.PublicationResource;

public class PublicationEntityToResource {
    public static PublicationResource toResourceFromEntity(Publication entity){
        return new PublicationResource(entity.getId(),entity.getTitle(),entity.getDescription(),entity.getImages(),entity.getViews(),entity.getLikes(),entity.getMentorProfile());
    }
}
