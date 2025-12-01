package com.transport.coop.mapper;

import com.transport.coop.entity.RouteEntity;
import com.transport.coop.model.Route;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-01T10:44:34-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RouteMapperImpl implements RouteMapper {

    @Override
    public RouteEntity toEntity(Route dto) {
        if ( dto == null ) {
            return null;
        }

        RouteEntity.RouteEntityBuilder routeEntity = RouteEntity.builder();

        if ( dto.getRouteId() != null ) {
            routeEntity.id( Long.parseLong( dto.getRouteId() ) );
        }
        routeEntity.name( dto.getCircuit() );

        return routeEntity.build();
    }

    @Override
    public Route toDto(RouteEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Route route = new Route();

        if ( entity.getId() != null ) {
            route.setRouteId( String.valueOf( entity.getId() ) );
        }
        route.setCircuit( entity.getName() );

        return route;
    }

    @Override
    public void updateEntityFromDto(Route dto, RouteEntity entity) {
        if ( dto == null ) {
            return;
        }
    }
}
