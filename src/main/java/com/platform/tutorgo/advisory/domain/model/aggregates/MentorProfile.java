package com.platform.tutorgo.advisory.domain.model.aggregates;


import com.platform.tutorgo.advisory.domain.model.valueobjects.PhoneNumber;
import com.platform.tutorgo.advisory.domain.model.valueobjects.UserProfilePhoto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Arrays;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class MentorProfile extends AbstractAggregateRoot<MentorProfile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String nick;

    @Setter
    @Embedded
    private PhoneNumber phonenumber;

    @Setter
    @Getter
    private String slogan;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String certificates;

    @Setter
    @Embedded
    private UserProfilePhoto userprofilephoto;



    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;


    public MentorProfile(String nick, String phonenumber, String slogan, String userprofilephoto, List<String> certificates, Mentor mentor){
        this.nick=nick;
        this.phonenumber=new PhoneNumber(phonenumber);
        this.slogan=slogan;
        this.userprofilephoto= new UserProfilePhoto(userprofilephoto);
        this.certificates=String.join(",", certificates);
        this.mentor=mentor;
    }
    public MentorProfile(){}

    public MentorProfile updateDescription(String slogan){
        this.slogan=slogan;
        return this;
    }

    public void updatePhoneNumber(String phonenumber) {
        this.phonenumber = new PhoneNumber(phonenumber);
    }
    public List<String> getCertificates() {
        return Arrays.asList(certificates.split(","));
    }
    public void updateUserProfilePhoto(UserProfilePhoto userprofilephoto) {
        this.userprofilephoto = userprofilephoto;
    }
    public String getPhoneNumber(){
        return this.phonenumber.phonenumber();
    }
    public  String getUserProfilePhoto(){
        return this.userprofilephoto.imageUrl();
    }
    public void updateNick(String nick) {
        this.nick = nick;
    }

    public MentorProfile updateMentorProfile(String nick,String phoneNumber, String slogan, String userProfilePhoto, List<String> certificates){
        this.nick=nick;
        this.phonenumber=new PhoneNumber(phoneNumber);
        this.slogan=slogan;
        this.userprofilephoto= new UserProfilePhoto(userProfilePhoto);
        this.certificates=String.join(",", certificates);
        return this;

    }
}