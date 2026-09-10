package com.makingbigger.portafoliojmc.domain.socialmedia;

import com.makingbigger.portafoliojmc.domain.personalinfo.PersonalInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Table(name = "social_media")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String platform;
    private String url;
    private String icon;
    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    private Boolean active = true;
}