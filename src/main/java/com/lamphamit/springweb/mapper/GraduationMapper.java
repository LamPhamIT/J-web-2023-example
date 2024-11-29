package com.lamphamit.springweb.mapper;

import com.lamphamit.springweb.dto.request.CreateGraduationRequest;
import com.lamphamit.springweb.entity.Graduation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GraduationMapper {
    Graduation toGraduationByCreateGraduationRequest(CreateGraduationRequest createGraduationRequest);
}
