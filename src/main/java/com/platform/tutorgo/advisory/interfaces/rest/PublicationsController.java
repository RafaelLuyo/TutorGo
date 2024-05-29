package com.platform.tutorgo.advisory.interfaces.rest;

import com.platform.tutorgo.advisory.domain.model.commands.DeletePublicationCommand;
import com.platform.tutorgo.advisory.domain.model.commands.IncrementViewPublicationCommand;
import com.platform.tutorgo.advisory.domain.model.commands.IncrementedLikePublicationCommand;
import com.platform.tutorgo.advisory.domain.model.queries.GetPublicationByIdQuery;
import com.platform.tutorgo.advisory.domain.services.commands.PublicationCommandService;
import com.platform.tutorgo.advisory.domain.services.queries.PublicationQueryService;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreatePublicationResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.PublicationResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.UpdatePublicationResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.CreatePublicationCommandFromResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.PublicationEntityToResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.UpdatePublicationCommandFromResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/publications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Publications", description = "Student Management Endpoints")
public class PublicationsController {
    private final PublicationCommandService publicationCommandService;
    private final PublicationQueryService publicationQueryService;
    public PublicationsController(PublicationCommandService publicationCommandService, PublicationQueryService publicationQueryService) {
        this.publicationCommandService = publicationCommandService;
        this.publicationQueryService = publicationQueryService;
    }
    @GetMapping
    public ResponseEntity<List<PublicationResource>> getPublications() {
        var listPublications=publicationQueryService.findAllPublications();
        List<PublicationResource> publicationResources = listPublications.stream()
                .map(PublicationEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publicationResources);
    }

    @GetMapping("/{publicationId}")
    public ResponseEntity<PublicationResource> getPublicationById(@PathVariable Long publicationId) {
        var getPublicationByIdQuery = new GetPublicationByIdQuery(publicationId);
        var publication=publicationQueryService.findPublicationById(getPublicationByIdQuery);
        var publicationResources = PublicationEntityToResource.toResourceFromEntity(publication.get());
        return ResponseEntity.ok(publicationResources);
    }
    @PostMapping
    public ResponseEntity<PublicationResource> createPublication(
            @RequestBody CreatePublicationResource resource
    ) {
        var CreatePublicationCommand = CreatePublicationCommandFromResource.resourceToCommand(resource);
        var publicationId = publicationCommandService.createPublication(CreatePublicationCommand);
        if (publicationId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getPublicationByIdQuery = new GetPublicationByIdQuery(publicationId);
        var publication=publicationQueryService.findPublicationById(getPublicationByIdQuery);

        if (publication.isEmpty()) return ResponseEntity.badRequest().build();

        var studentResource = PublicationEntityToResource.toResourceFromEntity(publication.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    @PutMapping("/{publicationId}")
    public ResponseEntity<PublicationResource> updatePublication(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource updatePublicationResource) {
        var updatePublicationCommand = UpdatePublicationCommandFromResource.toCommandFromResource(publicationId, updatePublicationResource);
        var updatedPublication = publicationCommandService.updatePublicationById(updatePublicationCommand);
        if (updatedPublication.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var publicationResource = PublicationEntityToResource.toResourceFromEntity(updatedPublication.get());
        return ResponseEntity.ok(publicationResource);
    }

    @DeleteMapping("/{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId) {
        var deletePublicationCommand = new DeletePublicationCommand(publicationId);
        publicationCommandService.deletePublication(deletePublicationCommand);
        return ResponseEntity.ok("Publication with given id successfully deleted");
    }

    @PostMapping("/{publicationId}/incrementView")
    public ResponseEntity<?> incrementViewPublication(@PathVariable Long publicationId) {
        var incrementViewPublicationCommand = new IncrementViewPublicationCommand(publicationId);
        var incrementViewPublicationId = publicationCommandService.incrementView(incrementViewPublicationCommand);
        return ResponseEntity.ok(incrementViewPublicationId);
    }

    @PostMapping("/{publicationId}/incrementLike")
    public ResponseEntity<?> incrementLikePublication(@PathVariable Long publicationId) {
        var incrementLikePublicationCommand = new IncrementedLikePublicationCommand(publicationId);
        var incrementLikePublicationId = publicationCommandService.incrementLike(incrementLikePublicationCommand);
        return ResponseEntity.ok(incrementLikePublicationId);
    }

    @PostMapping("/{publicationId}/discountLike")
    public ResponseEntity<?> discountLikePublication(@PathVariable Long publicationId) {
        var incrementLikePublicationCommand = new IncrementedLikePublicationCommand(publicationId);
        var incrementLikePublicationId = publicationCommandService.discountLike(incrementLikePublicationCommand);
        return ResponseEntity.ok(incrementLikePublicationId);
    }
}
