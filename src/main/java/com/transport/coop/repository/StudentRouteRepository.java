package com.transport.coop.repository;

import com.transport.coop.entity.StudentRouteEntity;
import com.transport.coop.entity.StudentRouteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRouteRepository extends JpaRepository<StudentRouteEntity, StudentRouteId> {
    List<StudentRouteEntity> findByStudentId(Long studentId);

    List<StudentRouteEntity> findByRouteId(Long routeId);

    void deleteByStudentIdAndRouteId(Long studentId, Long routeId);
}
