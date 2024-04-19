package com.fanta.newspriborzhavalyceum.database.mapper;

import com.fanta.newspriborzhavalyceum.database.dto.EventPlaceDTO;
import com.fanta.newspriborzhavalyceum.database.entity.Applications;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationsMapper {

    ApplicationsMapper INSTANCE = Mappers.getMapper(ApplicationsMapper.class);

    EventPlaceDTO ApplicationsDTO(Applications eventPlace);
}
