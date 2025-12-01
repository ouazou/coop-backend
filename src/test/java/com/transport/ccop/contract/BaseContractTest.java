package com.transport.coop.contract;

import com.transport.coop.controller.RouteController;
import com.transport.coop.model.Route;
import com.transport.coop.model.Student;
import com.transport.coop.service.RouteService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.time.LocalTime;
import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMessageVerifier
public class BaseContractTest {

    @Autowired
    private RouteController routeController;

    @MockBean
    private RouteService routeService;

    @BeforeEach
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(routeController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);

        // Setup mock responses
        Route route = new Route()
                .routeId("1")
                .circuit("601")
                .startTime(LocalTime.of(7, 15))
                .endTime(LocalTime.of(8, 15))
                .duration("60.49")
                .occupation("School Route");

        Student student = new Student()
                .studentId("1")
                .name("John Doe")
                .grade("Secondary");

        // Mock service methods
        Mockito.when(routeService.getAllRoutes())
                .thenReturn(Arrays.asList(route));

        Mockito.when(routeService.getRoute(1L))
                .thenReturn(route);

        Mockito.when(routeService.createRoute(Mockito.any(Route.class)))
                .thenReturn(route);

        Mockito.when(routeService.getRouteStudents(1L))
                .thenReturn(Arrays.asList(student));
    }
}
