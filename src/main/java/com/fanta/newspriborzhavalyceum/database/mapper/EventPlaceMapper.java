package com.fanta.newspriborzhavalyceum.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.fanta.newspriborzhavalyceum.database.dto.EventPlaceDTO;
import com.fanta.newspriborzhavalyceum.database.entity.EventPlace;

@Mapper
public interface EventPlaceMapper {

    EventPlaceMapper INSTANCE = Mappers.getMapper(EventPlaceMapper.class);

    EventPlaceDTO eventPlaceToEventPlaceDTO(EventPlace eventPlace);
}
