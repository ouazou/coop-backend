package com.transport.coop.mapper;

import com.transport.coop.entity.RouteEntity;
import com.transport.coop.model.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface RouteMapper {

    @Mapping(target = "id", source = "routeId")
    @Mapping(target = "name", source = "circuit")
    RouteEntity toEntity(Route dto);

    @Mapping(target = "routeId", source = "id")
    @Mapping(target = "circuit", source = "name")
    Route toDto(RouteEntity entity);

    void updateEntityFromDto(Route dto, @MappingTarget RouteEntity entity);
}
