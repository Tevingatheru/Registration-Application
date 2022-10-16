package com.web.registration.application.controller;

import com.web.registration.application.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    User toEntity(UserDTO userDTO);
}
