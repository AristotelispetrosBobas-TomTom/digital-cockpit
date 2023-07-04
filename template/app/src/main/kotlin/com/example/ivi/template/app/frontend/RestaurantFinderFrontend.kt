package com.example.ivi.template.app.frontend

import com.tomtom.ivi.platform.frontend.api.common.frontend.Frontend
import com.tomtom.ivi.platform.frontend.api.common.frontend.FrontendContext

/**
 * The [Frontend] for Restaurant Finder feature.
 */
internal class RestaurantFinderFrontend(frontendContext: FrontendContext) : Frontend(frontendContext) {
    override fun createMainTaskPanel() = RestaurantFinderPanel(frontendContext)
}
