package contracts.routes

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should delete a route"

    request {
        method DELETE()
        url "/routes/1"
    }

    response {
        status NO_CONTENT()
    }
}
