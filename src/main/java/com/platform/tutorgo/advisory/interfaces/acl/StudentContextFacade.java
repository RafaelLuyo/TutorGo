package com.platform.tutorgo.advisory.interfaces.acl;

import com.platform.tutorgo.advisory.domain.model.commands.CreateStudentCommand;
import com.platform.tutorgo.advisory.domain.model.queries.GetStudentByEmailQuery;
import com.platform.tutorgo.advisory.domain.model.valueobjects.EmailAddress;
import com.platform.tutorgo.advisory.domain.services.commands.StudentCommandService;
import com.platform.tutorgo.advisory.domain.services.queries.StudentQueryService;

//capa de anticorrupción para comunicarse con otros bounden context
public class StudentContextFacade {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentContextFacade(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    public Long createStudent(String firstName,String lastName, String email, String password, String subscription){
        var createStudentCommand = new CreateStudentCommand(firstName,lastName,email,password,subscription);
        return studentCommandService.createStudent(createStudentCommand);
    }

    public Long getStudentIdByEmail(String email){
        var getStudentByEmailQuery = (new GetStudentByEmailQuery(new EmailAddress(email)));
        var student = studentQueryService.findStudentByEmail(getStudentByEmailQuery);
        if(student.isEmpty())return 0L;
        return student.get().getId();
    }
}
