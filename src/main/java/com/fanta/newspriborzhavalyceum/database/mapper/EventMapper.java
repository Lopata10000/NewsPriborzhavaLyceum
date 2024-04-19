package com.fanta.newspriborzhavalyceum.database.mapper;

import com.fanta.newspriborzhavalyceum.database.dto.EventDTO;
import com.fanta.newspriborzhavalyceum.database.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "id", ignore = true)
    Event eventDTOToEvent(EventDTO eventDTO);

    EventDTO eventToEventDTO(Event event);
}

