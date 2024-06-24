package com.platform.tutorgo.advisory.interfaces.rest.transform;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import com.platform.tutorgo.advisory.interfaces.rest.resources.MentorResource;

public class MentorEntityToResource {
    public static MentorResource EntityToResource(Mentor mentor){
        return new MentorResource (mentor.getId(),mentor.getStudent());
    }
}
