package com.makingbigger.portafoliojmc.controller.admin;

import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaDetailDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaRegisterDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaUpdateDto;
import com.makingbigger.portafoliojmc.services.SocialMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/admin/social-media")
@RequiredArgsConstructor
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @GetMapping
    public ResponseEntity<List<SocialMediaDetailDto>> getAllSocialMedia() {
        var socialMediaList = socialMediaService.getAllSocialMedia();
        return ResponseEntity.ok(socialMediaList);
    }

    @GetMapping(path = "/{platform}")
    public ResponseEntity<SocialMediaDetailDto> getSocialMediaByPlatform(@PathVariable String platform) {
        var foundSocialMedia = socialMediaService.getSocialMediaByPlatform(platform);
        return ResponseEntity.ok(foundSocialMedia);
    }

    @PostMapping
    public ResponseEntity<SocialMediaDetailDto> registerSocialMedia(@RequestBody SocialMediaRegisterDto dto, UriComponentsBuilder builder) {
        var newSocialMedia = socialMediaService.registerSocialMedia(dto);
        var uri = builder.path("/admin/social-media/{platform}")
                .buildAndExpand(newSocialMedia.platform())
                .toUri();
        return ResponseEntity.created(uri).body(newSocialMedia);
    }

    @PatchMapping(path = "/{platform}")
    public ResponseEntity<SocialMediaDetailDto> updateSocialMedia(@PathVariable String platform, @RequestBody SocialMediaUpdateDto dto) {
        var updatedSocialMedia = socialMediaService.updateSocialMedia(platform, dto);
        return ResponseEntity.ok(updatedSocialMedia);
    }

    @DeleteMapping(path = "/{platform}")
    public ResponseEntity<String> deleteSocialMedia(@PathVariable String platform) {
        var response = socialMediaService.deleteSocialMedia(platform);
        return ResponseEntity.ok(response);
    }
}