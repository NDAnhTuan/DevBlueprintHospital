package com.example.PetProject.mapper;

import com.example.PetProject.dto.request.MyUserCreationRequest;
import com.example.PetProject.dto.request.ProfileCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(MyUserCreationRequest request);
}
