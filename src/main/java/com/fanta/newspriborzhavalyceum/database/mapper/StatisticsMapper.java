package com.fanta.newspriborzhavalyceum.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.fanta.newspriborzhavalyceum.database.dto.StatisticsDTO;
import com.fanta.newspriborzhavalyceum.database.entity.Statistics;

@Mapper
public interface StatisticsMapper {

    StatisticsMapper INSTANCE = Mappers.getMapper(StatisticsMapper.class);

    StatisticsDTO statisticsToStatisticsDTO(Statistics statistics);
}

