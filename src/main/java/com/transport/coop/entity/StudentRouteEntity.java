package com.transport.coop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRouteEntity {

    @EmbeddedId
    private StudentRouteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("routeId")
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @Column(name = "pickup_order", nullable = false)
    private Integer pickupOrder;
}
