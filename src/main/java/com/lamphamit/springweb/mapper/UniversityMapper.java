package com.lamphamit.springweb.mapper;

import com.lamphamit.springweb.dto.response.UniversityCodeResponse;
import com.lamphamit.springweb.entity.University;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityMapper {
    UniversityCodeResponse universityToUniversityResponse(University university);
}
