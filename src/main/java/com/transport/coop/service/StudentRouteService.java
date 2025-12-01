package com.transport.coop.service;

import com.transport.coop.entity.RouteEntity;
import com.transport.coop.entity.StudentEntity;
import com.transport.coop.entity.StudentRouteEntity;
import com.transport.coop.entity.StudentRouteId;
import com.transport.coop.repository.StudentRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentRouteService {

    private final StudentRouteRepository studentRouteRepository;

    public void addStudentToRoute(StudentEntity student, RouteEntity route, Integer pickupOrder) {
        StudentRouteId id = new StudentRouteId(student.getId(), route.getId());
        StudentRouteEntity studentRoute = StudentRouteEntity.builder()
                .id(id)
                .student(student)
                .route(route)
                .pickupOrder(pickupOrder)
                .build();

        studentRouteRepository.save(studentRoute);
    }

    public void removeStudentFromRoute(Long studentId, Long routeId) {
        studentRouteRepository.deleteByStudentIdAndRouteId(studentId, routeId);
    }
}
