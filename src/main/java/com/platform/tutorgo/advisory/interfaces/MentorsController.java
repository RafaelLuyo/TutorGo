package com.platform.tutorgo.advisory.interfaces;

import com.platform.tutorgo.advisory.domain.model.queries.GetMentorByIdQuery;
import com.platform.tutorgo.advisory.domain.services.commands.MentorCommandService;
import com.platform.tutorgo.advisory.domain.services.queries.MentorQueryService;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateMentorResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.MentorResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.CreateMentorCommandFromResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.MentorEntityToResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/mentors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mentors", description = "Mentors Management Endpoints")
public class MentorsController {
    private final MentorQueryService mentorQueryService;
    private final MentorCommandService mentorCommandService;

    public MentorsController(MentorQueryService mentorQueryService, MentorCommandService mentorCommandService) {
        this.mentorQueryService = mentorQueryService;
        this.mentorCommandService = mentorCommandService;
    }

    @PostMapping
    public ResponseEntity<MentorResource> createUserMentor(@RequestBody CreateMentorResource resource){
        var createMentorCommand = CreateMentorCommandFromResource.resourceToCommand(resource);
        var MentorId = mentorCommandService.createMentor(createMentorCommand);
        if(MentorId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var GetMentorByIdQuery = new GetMentorByIdQuery(MentorId);
        var userMentor = mentorQueryService.findMentorById(GetMentorByIdQuery);

        if (userMentor.isEmpty()) return ResponseEntity.badRequest().build();

        var MentorResource = MentorEntityToResource.EntityToResource(userMentor.get());
        return new ResponseEntity<>(MentorResource, HttpStatus.CREATED);
    }
}
