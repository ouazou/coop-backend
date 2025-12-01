package contracts.routes

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 404 when route not found"

    request {
        method GET()
        url "/routes/999"
    }

    response {
        status NOT_FOUND()
    }
}
