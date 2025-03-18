package com.devblueprint.patient_service.mapper;

import com.devblueprint.patient_service.dto.request.ProfileCreationRequest;
import com.devblueprint.patient_service.dto.response.UserProfileResponse;
import com.devblueprint.patient_service.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
