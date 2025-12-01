package com.transport.coop.controller;

import com.transport.coop.api.RoutesApi;
import com.transport.coop.model.Route;
import com.transport.coop.model.Student;
import com.transport.coop.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteController implements RoutesApi {

    private final RouteService routeService;

    @Override
    public ResponseEntity<List<Route>> routesGet() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @Override
    public ResponseEntity<Route> routesPost(Route route) {
        return ResponseEntity.ok(routeService.createRoute(route));
    }

    @Override
    public ResponseEntity<Void> routesRouteIdDelete(String routeId) {
        routeService.deleteRoute(Long.parseLong(routeId));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Route> routesRouteIdGet(String routeId) {
        return ResponseEntity.ok(routeService.getRoute(Long.parseLong(routeId)));
    }

    @Override
    public ResponseEntity<Void> routesRouteIdPut(String routeId, Route route) {
        routeService.updateRoute(Long.parseLong(routeId), route);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Student>> routesRouteIdStudentsGet(String routeId) {
        return ResponseEntity.ok(routeService.getRouteStudents(Long.parseLong(routeId)));
    }

    @Override
    public ResponseEntity<Student> routesRouteIdStudentsPost(String routeId, Student student) {
        return ResponseEntity.ok(routeService.addStudentToRoute(Long.parseLong(routeId), student));
    }

    @Override
    public ResponseEntity<Void> routesRouteIdStudentsStudentIdDelete(String routeId, String studentId) {
        routeService.removeStudentFromRoute(Long.parseLong(routeId), Long.parseLong(studentId));
        return ResponseEntity.noContent().build();
    }
}
