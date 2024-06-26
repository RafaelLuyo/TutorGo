package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import com.platform.tutorgo.advisory.interfaces.rest.resources.MentorProfileResource;

public class MentorProfileEntityToResource {
    public static MentorProfileResource toResourceFromEntity(MentorProfile entity) {
        return new MentorProfileResource(
                entity.getId(),
                entity.getNick(),
                entity.getPhoneNumber(),
                entity.getSlogan(),
                entity.getUserProfilePhoto(),
                entity.getCertificates(),
                entity.getMentor()
        );
    }
}
