package com.example.ivi.template.app.frontend

import com.tomtom.ivi.platform.frontend.api.common.frontend.Frontend
import com.tomtom.ivi.platform.frontend.api.common.frontend.FrontendBuilder
import com.tomtom.ivi.platform.frontend.api.common.frontend.FrontendContext

/**
 * Builds [RestaurantFinderFrontend].
 */
class RestaurantFinderFrontendBuilder: FrontendBuilder() {

    override fun build(frontendContext: FrontendContext): Frontend =
        RestaurantFinderFrontend(frontendContext)
}
