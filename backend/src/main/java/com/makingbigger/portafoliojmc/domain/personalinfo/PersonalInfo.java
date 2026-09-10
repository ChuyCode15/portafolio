package com.makingbigger.portafoliojmc.domain.personalinfo;

import com.makingbigger.portafoliojmc.domain.socialmedia.SocialMedia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "personal_info")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String title;
    private String subtitle;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String email;
    private String phone;
    private String location;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "cv_url")
    private String cvUrl;

    private String availability;

    @OneToMany(mappedBy = "personalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialMedia> socialMediaLinks = new ArrayList<>();
}
