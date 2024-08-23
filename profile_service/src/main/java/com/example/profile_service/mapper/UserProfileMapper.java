package com.example.profile_service.mapper;

import org.mapstruct.Mapper;

import com.example.profile_service.dto.request.ProfileCreationRequest;
import com.example.profile_service.dto.response.UserProfileResponse;
import com.example.profile_service.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile entity);
}
