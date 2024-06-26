package com.platform.tutorgo.advisory.interfaces;


import com.platform.tutorgo.advisory.application.internal.commandServices.StudentCommandServiceImpl;
import com.platform.tutorgo.advisory.application.internal.queryservices.StudentQueryServiceImpl;
import com.platform.tutorgo.advisory.domain.model.queries.GetStudentByIdQuery;
import com.platform.tutorgo.advisory.interfaces.rest.resources.CreateStudentResource;
import com.platform.tutorgo.advisory.interfaces.rest.resources.StudentResource;
import com.platform.tutorgo.advisory.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.platform.tutorgo.advisory.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentsController {
    private final StudentQueryServiceImpl studentQueryServiceImpl;
    private final StudentCommandServiceImpl studentCommandServiceImpl;

    public StudentsController(StudentQueryServiceImpl studentQueryServiceImpl, StudentCommandServiceImpl studentCommandServiceImpl) {
        this.studentQueryServiceImpl = studentQueryServiceImpl;
        this.studentCommandServiceImpl = studentCommandServiceImpl;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandServiceImpl.createStudent(createStudentCommand);
        if (studentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryServiceImpl.findStudentById(getStudentByIdQuery);

        if (student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResource> getStudentById(@PathVariable Long studentId) {
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryServiceImpl.findStudentById(getStudentByIdQuery);
        if (student.isEmpty()) return ResponseEntity.badRequest().build();
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }
    @GetMapping
    public ResponseEntity<List<StudentResource>> getStudents() {
        var listStudents=studentQueryServiceImpl.findAllStudents();
        List<StudentResource> studentResources = listStudents.stream()
                .map(StudentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentResources);
    }
}
