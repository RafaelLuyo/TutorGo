package com.platform.tutorgo.advisory.domain.model.aggregates;

import com.platform.tutorgo.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Arrays;
import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class Publication extends AuditableModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String description;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String images;

    @Getter
    private Integer views;

    @Getter
    private Integer likes;

    @ManyToOne
    @Getter
    @JoinColumn(name = "mentorProfile_id")
    private MentorProfile mentorProfile;


    public Publication(String title, String description, List<String> image, MentorProfile mentorProfile){
        this.title=title;
        this.description=description;
        this.images=String.join(",", image);
        this.views=0;
        this.likes=0;
        this.mentorProfile=mentorProfile;
    }
    public Publication(){}

    public void incrementView(){
        this.views = views+1;
    }
    public void incrementLike(){
        this.likes = likes+1;
    }
    public void discountLike(){
        this.likes = likes-1;
    }
    public List<String> getImages() {
        return Arrays.asList(images.split(","));
    }

    public Publication updatePublication(String title,String description, List<String> images){
        this.title = title;
        this.description=description;
        this.images=String.join(",", images);
        return this;
    }
}
