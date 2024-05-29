package com.platform.tutorgo.advisory.application.internal.commandServices;

import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import com.platform.tutorgo.advisory.domain.model.aggregates.Publication;
import com.platform.tutorgo.advisory.domain.model.commands.*;
import com.platform.tutorgo.advisory.domain.services.commands.PublicationCommandService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {
    private final PublicationRepository publicationRepository;
    private final MentorProfileRepository mentorProfileRepository;
    public PublicationCommandServiceImpl(PublicationRepository publicationRepository, MentorProfileRepository mentorProfileRepository) {
        this.publicationRepository = publicationRepository;
        this.mentorProfileRepository = mentorProfileRepository;
    }


    @Override
    public Long createPublication(CreatePublicationCommand command) {
        MentorProfile mentorProfile = mentorProfileRepository.findById(command.mentorProfileId()).orElseThrow();
        var publication = new Publication(command.title(),command.description(),command.images(),mentorProfile);
        publicationRepository.save(publication);
        return publication.getId();
    }

    @Override
    public Optional<Publication> updatePublicationById(UpdatePublicationCommand command) {
        if (!publicationRepository.existsById(command.id()))throw new IllegalArgumentException("Publication does not exist");
        var publicationToUpdate = publicationRepository.findById(command.id()).get();
        var updatePublication = publicationRepository.save(publicationToUpdate.updatePublication(
                command.title(),command.description(), command.images())
        );
        return Optional.of(updatePublication);
    }

    @Override
    public void deletePublication(DeletePublicationCommand command) {
        if (!publicationRepository.existsById(command.publicationId())){
            throw new IllegalArgumentException("Publication does not exist");
        }
        publicationRepository.deleteById(command.publicationId());
    }

    @Override
    public Long incrementView(IncrementViewPublicationCommand command) {
        publicationRepository.findById(command.publicationId())
                .map(publication -> {
                    publication.incrementView();
                    publicationRepository.save(publication);
                    return publication.getId();
                }).orElseThrow(()-> new RuntimeException("Publication not found"));
        return null;
    }

    @Override
    public Long incrementLike(IncrementedLikePublicationCommand command) {
        publicationRepository.findById(command.publicationId())
                .map(publication -> {
                    publication.incrementLike();
                    publicationRepository.save(publication);
                    return publication.getId();
                }).orElseThrow(()-> new RuntimeException("Publication not found"));
        return null;
    }

    @Override
    public Long discountLike(IncrementedLikePublicationCommand command) {
        publicationRepository.findById(command.publicationId())
                .map(publication -> {
                    publication.discountLike();
                    publicationRepository.save(publication);
                    return publication.getId();
                }).orElseThrow(()-> new RuntimeException("Publication not found"));
        return null;
    }
}
