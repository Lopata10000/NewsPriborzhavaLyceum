package com.fanta.newspriborzhavalyceum.database.mapper;

import com.fanta.newspriborzhavalyceum.database.dto.UserDTO;
import com.fanta.newspriborzhavalyceum.database.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
