package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.commands.UpdatePublicationCommand;
import com.platform.tutorgo.advisory.interfaces.rest.resources.UpdatePublicationResource;

public class UpdatePublicationCommandFromResource {
    public static UpdatePublicationCommand toCommandFromResource(Long publicationId, UpdatePublicationResource resource){
        return new UpdatePublicationCommand(publicationId, resource.title(), resource.description(),resource.images() );
    }
}
