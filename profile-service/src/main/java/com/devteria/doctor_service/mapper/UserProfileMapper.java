package com.devteria.doctor_service.mapper;

import org.mapstruct.Mapper;

import com.devteria.doctor_service.dto.request.ProfileCreationRequest;
import com.devteria.doctor_service.dto.response.UserProfileResponse;
import com.devteria.doctor_service.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
