package com.platform.tutorgo.advisory.interfaces;

import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import com.platform.tutorgo.advisory.domain.model.commands.CreateMentorProfileCommand;
import com.platform.tutorgo.advisory.domain.model.commands.UpdateMentorProfileCommand;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorProfileByIdQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorProfileByMentorIdQuery;
import com.platform.tutorgo.advisory.domain.services.commands.MentorProfileCommandService;
import com.platform.tutorgo.advisory.domain.services.queries.MentorProfileQueryService;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateMentorProfileResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.MentorProfileResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.UpdateMentorProfileResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.CreateMentorProfileCommandFromResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.MentorProfileEntityToResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.UpdateMentorProfileCommandFromResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/mentorprofiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mentor Profiles", description = "Mentor Profile Management Endpoints")
public class MentorProfilesController {
    private final MentorProfileQueryService mentorProfileQueryService;
    private final MentorProfileCommandService mentorProfileCommandService;

    public MentorProfilesController(MentorProfileQueryService mentorProfileQueryService, MentorProfileCommandService mentorProfileCommandService) {
        this.mentorProfileQueryService = mentorProfileQueryService;
        this.mentorProfileCommandService = mentorProfileCommandService;
    }

    @PostMapping
    public ResponseEntity<MentorProfileResource> createMentorProfile(@RequestBody CreateMentorProfileResource resource) {
        CreateMentorProfileCommand command = CreateMentorProfileCommandFromResource.resourceToCommand(resource);
        Long createdMentorProfileId = mentorProfileCommandService.createMentorProfile(command);

        if (createdMentorProfileId != null) {
            var getMentorProfileByStudentId = new GetMentorProfileByIdQuery(createdMentorProfileId);
            Optional<MentorProfile> createdProfile = mentorProfileQueryService.findMentorProfileById(getMentorProfileByStudentId);

            if (createdProfile.isPresent()) {
               MentorProfileResource profileResource = MentorProfileEntityToResource.toResourceFromEntity(createdProfile.get());
                return ResponseEntity.status(HttpStatus.CREATED).body(profileResource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/{mentorId}")
    public ResponseEntity<MentorProfileResource> getMentorProfileByStudentId(@PathVariable Long mentorId) {
        GetMentorProfileByMentorIdQuery query = new GetMentorProfileByMentorIdQuery(mentorId);
        Optional<MentorProfile> mentorProfile = mentorProfileQueryService.findMentorProfileByMentorId(query);

        if (mentorProfile.isPresent()) {
            MentorProfileResource profileResource = MentorProfileEntityToResource.toResourceFromEntity(mentorProfile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MentorProfileResource>> getAllMentorProfiles() {
        List<MentorProfile> mentorprofiles = mentorProfileQueryService.findAllMentorProfiles();

        List<MentorProfileResource> profileResources = mentorprofiles.stream()
                .map(MentorProfileEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(profileResources);
    }

    @PutMapping("/{mentorProfileId}")
    public ResponseEntity<MentorProfileResource> updateMentorProfile(
            @PathVariable Long mentorProfileId,
            @RequestBody UpdateMentorProfileResource resource) {
        UpdateMentorProfileCommand command = UpdateMentorProfileCommandFromResource.toCommandFromResource(mentorProfileId, resource);
        Optional<MentorProfile> updatedProfile = mentorProfileCommandService.updateMentorProfileByID(command);

        if (updatedProfile.isPresent()) {
            MentorProfileResource profileResource = MentorProfileEntityToResource.toResourceFromEntity(updatedProfile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
