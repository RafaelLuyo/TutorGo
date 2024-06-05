package com.platform.tutorgo.advisory.domain.model.aggregates;


import com.platform.tutorgo.advisory.domain.model.valueobjects.StatusAppointment;
import com.platform.tutorgo.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Appointment extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String description;

    private StatusAppointment status;

    @ManyToOne
    @Getter
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;



    public Appointment(String description, Student student, Mentor mentor){
        this.description= description;
        this.status= StatusAppointment.REQUESTED;
        this.student = student;
        this.mentor=mentor;
    }
    public Appointment() {
    }

    public void confirm() {
        this.status = StatusAppointment.CONFIRMED;
    }
    public void reject() {
        this.status = StatusAppointment.REJECTED;
    }

    public void cancel() {
        this.status = StatusAppointment.CANCELLED;
    }

    public String getStatus() {
        return this.status.name().toLowerCase();
    }
}
