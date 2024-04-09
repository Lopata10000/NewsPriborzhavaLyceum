package com.fanta.newspriborzhavalyceum.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.fanta.newspriborzhavalyceum.database.dto.RoleDTO;
import com.fanta.newspriborzhavalyceum.database.entity.Role;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO roleToRoleDTO(Role role);
}

