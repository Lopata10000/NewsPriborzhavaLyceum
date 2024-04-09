package com.fanta.newspriborzhavalyceum.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.fanta.newspriborzhavalyceum.database.dto.EventDTO;
import com.fanta.newspriborzhavalyceum.database.entity.Event;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "id", ignore = true)
    Event eventDTOToEvent(EventDTO eventDTO);

    EventDTO eventToEventDTO(Event event);
}

