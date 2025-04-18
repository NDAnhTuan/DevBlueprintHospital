package com.devteria.swagger.service;

import com.devteria.swagger.exception.AppException;
import com.devteria.swagger.exception.ErrorCode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devteria.swagger.dto.request.ProfileCreationRequest;
import com.devteria.swagger.dto.response.UserProfileResponse;
import com.devteria.swagger.entity.UserProfile;
import com.devteria.swagger.mapper.UserProfileMapper;
import com.devteria.swagger.repository.UserProfileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileReponse(userProfile);
    }

    public UserProfileResponse getProfile(String id) {
        UserProfile userProfile =
                userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return userProfileMapper.toUserProfileReponse(userProfile);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> getAllProfiles() {
        var profiles = userProfileRepository.findAll();

        return profiles.stream().map(userProfileMapper::toUserProfileReponse).toList();
    }

    public UserProfileResponse getMyProfile() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.getName());
        String userId = authentication.getName();

        var profile = userProfileRepository.findByEmail(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userProfileMapper.toUserProfileReponse(profile);
    }
}
