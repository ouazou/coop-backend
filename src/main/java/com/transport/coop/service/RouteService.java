package com.transport.coop.service;

import com.transport.coop.entity.RouteEntity;
import com.transport.coop.entity.StudentEntity;
import com.transport.coop.mapper.RouteMapper;
import com.transport.coop.mapper.StudentMapper;
import com.transport.coop.model.Route;
import com.transport.coop.model.Student;
import com.transport.coop.repository.RouteRepository;
import com.transport.coop.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RouteService {

    private final RouteRepository routeRepository;
    private final StudentRepository studentRepository;
    private final StudentRouteService studentRouteService;
    private final RouteMapper routeMapper;
    private final StudentMapper studentMapper;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }

    public Route getRoute(Long routeId) {
        return routeRepository.findById(routeId)
                .map(routeMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Route not found: " + routeId));
    }

    public Route createRoute(Route route) {
        RouteEntity entity = routeMapper.toEntity(route);
        return routeMapper.toDto(routeRepository.save(entity));
    }

    public Route updateRoute(Long routeId, Route route) {
        RouteEntity entity = routeRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found: " + routeId));

        routeMapper.updateEntityFromDto(route, entity);
        return routeMapper.toDto(routeRepository.save(entity));
    }

    public void deleteRoute(Long routeId) {
        if (!routeRepository.existsById(routeId)) {
            throw new EntityNotFoundException("Route not found: " + routeId);
        }
        routeRepository.deleteById(routeId);
    }

    public List<Student> getRouteStudents(Long routeId) {
        RouteEntity route = routeRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found: " + routeId));

        return route.getStudentRoutes().stream()
                .map(sr -> studentMapper.toDto(sr.getStudent()))
                .collect(Collectors.toList());
    }

    public Student addStudentToRoute(Long routeId, Student student) {
        RouteEntity route = routeRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found: " + routeId));

        StudentEntity studentEntity = studentMapper.toEntity(student);
        studentEntity = studentRepository.save(studentEntity);

        // Add student to route using StudentRouteService
        studentRouteService.addStudentToRoute(studentEntity, route, 0); // Default pickup order

        return studentMapper.toDto(studentEntity);
    }

    public void removeStudentFromRoute(Long routeId, Long studentId) {
        if (!routeRepository.existsById(routeId)) {
            throw new EntityNotFoundException("Route not found: " + routeId);
        }
        if (!studentRepository.existsById(studentId)) {
            throw new EntityNotFoundException("Student not found: " + studentId);
        }

        studentRouteService.removeStudentFromRoute(studentId, routeId);
    }
}
