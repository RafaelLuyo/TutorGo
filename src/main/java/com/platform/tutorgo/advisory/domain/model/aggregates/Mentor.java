package com.platform.tutorgo.advisory.domain.model.aggregates;

import com.platform.tutorgo.advisory.domain.model.valueobjects.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;




    @ManyToOne
    @Getter
    @JoinColumn(name = "student_id")
    private Student student;

    public Mentor( Student student){

        this.student=student;
    }

    public Mentor(){}


}
