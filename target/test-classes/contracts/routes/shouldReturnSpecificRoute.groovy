package contracts.routes

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a specific route"

    request {
        method GET()
        url "/routes/1"
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body([
                routeId   : "1",
                circuit   : "601",
                startTime : "07:15",
                endTime   : "08:15",
                duration  : "60.49",
                occupation: "School Route"
        ])
    }
}
