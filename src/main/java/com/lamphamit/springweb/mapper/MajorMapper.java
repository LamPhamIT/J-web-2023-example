package com.lamphamit.springweb.mapper;

import com.lamphamit.springweb.dto.response.MajorCodeResponse;
import com.lamphamit.springweb.entity.Major;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MajorMapper {
    MajorCodeResponse toMajorCodeResponse(Major major);
}
