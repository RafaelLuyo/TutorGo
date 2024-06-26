package com.platform.tutorgo.advisory.domain.services.queries;
import com.platform.tutorgo.advisory.domain.model.aggregates.Student;
import com.platform.tutorgo.advisory.domain.model.queries.GetStudentByEmailQuery;
import com.platform.tutorgo.advisory.domain.model.queries.GetStudentByIdQuery;

import java.util.List;
import java.util.Optional;


public interface StudentQueryService {
    Optional<Student> findStudentByEmail(GetStudentByEmailQuery query);
    Optional<Student> findStudentById(GetStudentByIdQuery query);
    List<Student>findAllStudents();
}
