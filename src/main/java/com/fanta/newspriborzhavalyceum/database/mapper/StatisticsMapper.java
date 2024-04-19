package com.fanta.newspriborzhavalyceum.database.mapper;

import com.fanta.newspriborzhavalyceum.database.dto.StatisticsDTO;
import com.fanta.newspriborzhavalyceum.database.entity.Statistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatisticsMapper {

    StatisticsMapper INSTANCE = Mappers.getMapper(StatisticsMapper.class);

    StatisticsDTO statisticsToStatisticsDTO(Statistics statistics);
}

