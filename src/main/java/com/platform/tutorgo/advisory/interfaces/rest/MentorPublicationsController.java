package com.platform.tutorgo.advisory.interfaces.rest;

import com.platform.tutorgo.advisory.domain.model.queries.GetPublicationByMentorIdQuery;
import com.platform.tutorgo.advisory.domain.services.queries.PublicationQueryService;
import com.platform.tutorgo.advisory.interfaces.rest.resources.PublicationResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.PublicationEntityToResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/mentors/{mentorId}/publications", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Mentors")
public class MentorPublicationsController {
    private final PublicationQueryService publicationQueryService;

    public MentorPublicationsController( PublicationQueryService publicationQueryService) {

        this.publicationQueryService = publicationQueryService;
    }
    @GetMapping
    public ResponseEntity<List<PublicationResource>> getPublicationsByIdMentor(@PathVariable Long mentorId) {
        var getPublicationByMentorIdQuery=new GetPublicationByMentorIdQuery(mentorId);
        var listPublications=publicationQueryService.findPublicationByMentorId(getPublicationByMentorIdQuery);
        List<PublicationResource> publicationResources = listPublications.stream()
                .map(PublicationEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publicationResources);
    }
}
