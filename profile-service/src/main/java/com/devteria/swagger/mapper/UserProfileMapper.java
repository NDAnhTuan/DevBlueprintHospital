package com.devteria.swagger.mapper;

import org.mapstruct.Mapper;

import com.devteria.swagger.dto.request.ProfileCreationRequest;
import com.devteria.swagger.dto.response.UserProfileResponse;
import com.devteria.swagger.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
