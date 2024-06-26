package com.platform.tutorgo.advisory.domain.model.aggregates;

import com.platform.tutorgo.advisory.domain.model.valueobjects.EmailAddress;
import com.platform.tutorgo.advisory.domain.model.valueobjects.Password;
import com.platform.tutorgo.advisory.domain.model.valueobjects.StudentName;
import com.platform.tutorgo.advisory.domain.model.valueobjects.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Student extends AbstractAggregateRoot<Student> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private StudentName name;

    @Embedded
    private EmailAddress email;

    @Embedded
    private Password password;


    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Student(String firstName, String lastName, String email, String password) {
        this.name = new StudentName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.password = new Password(password);

    }

    public Student() {

    }
    //DDD => lenguaje ubicuo y no obliga al exterior a crear un parámetro.
    public void updateEmail(String email){
        this.email= new EmailAddress(email);
    }

    public void updatePassword(String password){
        this.password = new Password(password);
    }
    public String getStudentName(){
        return this.name.getFullName();
    }

    public String getEmailAddress(){return this.email.address();}
    public String getPassword(){return this.password.password();}

}
