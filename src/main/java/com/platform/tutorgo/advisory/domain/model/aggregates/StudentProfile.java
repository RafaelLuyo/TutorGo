package com.platform.tutorgo.advisory.domain.model.aggregates;


import com.platform.tutorgo.advisory.domain.model.valueobjects.PhoneNumber;
import com.platform.tutorgo.advisory.domain.model.valueobjects.UserProfilePhoto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class StudentProfile extends AbstractAggregateRoot<StudentProfile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String nick;

    @Setter
    @Embedded
    private PhoneNumber phoneNumber;

    @Setter
    @Getter
    private String slogan;

    @Setter
    @Embedded
    private UserProfilePhoto userProfilePhoto;



    @ManyToOne
    @Getter
    @JoinColumn(name = "student_id")
    private Student student;


    public StudentProfile(String nick, String phoneNumber, String slogan, String userProfilePhoto, Student student){
        this.nick=nick;
        this.phoneNumber=new PhoneNumber(phoneNumber);
        this.slogan=slogan;
        this.userProfilePhoto= new UserProfilePhoto(userProfilePhoto);
        this.student=student;
    }
    public StudentProfile(){}

    public StudentProfile updateSlogan(String slogan){
        this.slogan=slogan;
        return this;
    }
    public void updatePhoneNumber(String phonenumber) {
        this.phoneNumber = new PhoneNumber(phonenumber);
    }
    public void updateUserProfilePhoto(UserProfilePhoto userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }
    public String getPhoneNumber(){
        return this.phoneNumber.phonenumber();
    }
    public  String getUserProfilePhoto(){
        return this.userProfilePhoto.imageUrl();
    }

    public void updateNick(String nick) {
        this.nick = nick;
    }
}