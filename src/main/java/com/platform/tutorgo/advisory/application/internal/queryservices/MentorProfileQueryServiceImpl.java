package com.platform.tutorgo.advisory.application.internal.queryservices;

import com.platform.tutorgo.advisory.domain.model.aggregates.MentorProfile;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorProfileByIdQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorProfileByMentorIdQuery;
import com.platform.tutorgo.advisory.domain.services.queries.MentorProfileQueryService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MentorProfileQueryServiceImpl implements MentorProfileQueryService {

    private final MentorProfileRepository mentorProfileRepository;

    public MentorProfileQueryServiceImpl(MentorProfileRepository mentorProfileRepository) {
        this.mentorProfileRepository = mentorProfileRepository;
    }

    @Override
    public Optional<MentorProfile> findMentorProfileByMentorId(GetMentorProfileByMentorIdQuery query) {

        List<MentorProfile> profiles = mentorProfileRepository.findByMentorId(query.mentorId());
        return profiles.isEmpty() ? Optional.empty() : Optional.of(profiles.get(0));
    }

    @Override
    public Optional<MentorProfile> findMentorProfileById(GetMentorProfileByIdQuery query) {
        return  mentorProfileRepository.findById(query.mentorProfileId());
    }

    @Override
    public List<MentorProfile> findAllMentorProfiles() {
        return mentorProfileRepository.findAll();
    }

 }
