package contracts.routes

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return students in a route"

    request {
        method GET()
        url "/routes/1/students"
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body([
                [
                        studentId: "1",
                        name     : "John Doe",
                        grade    : "Secondary"
                ]
        ])
    }
}
