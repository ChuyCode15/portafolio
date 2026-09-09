package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.personalinfo.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, UUID> {

    @Query("SELECT DISTINCT p FROM PersonalInfo p LEFT JOIN FETCH p.socialMediaLinks s WHERE (s IS NULL OR s.active = true)")
    Optional<PersonalInfo> findFirstWithActiveSocialMedia();

    Optional<PersonalInfo> findFirstBy();

}
