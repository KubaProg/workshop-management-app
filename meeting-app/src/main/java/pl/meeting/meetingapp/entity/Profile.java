package pl.meeting.meetingapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.meeting.meetingapp.models.CategoryModelApi;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
public class Profile {

    @Id
    private Integer id;


    private Integer userId;
    private String sex;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profile_category",
            joinColumns = @JoinColumn(name = "PROFILE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<Category> interests;
    private String job;
    private String school;
    private String description;
    private String photo;
    private String city;
}
