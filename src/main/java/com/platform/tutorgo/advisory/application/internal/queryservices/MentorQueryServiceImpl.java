package com.platform.tutorgo.advisory.application.internal.queryservices;

import com.platform.tutorgo.advisory.domain.model.aggregates.Mentor;
import com.platform.tutorgo.advisory.domain.model.queries.GetMentorByIdQuery;
import com.platform.tutorgo.advisory.domain.services.queries.MentorQueryService;
import com.platform.tutorgo.advisory.infrastructure.persistence.jpa.repositories.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorQueryServiceImpl implements MentorQueryService {

    private final MentorRepository mentorRepository;

    public MentorQueryServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Optional<Mentor> findMentorById(GetMentorByIdQuery query) {
        return mentorRepository.findById(query.idMentor());
    }
}
