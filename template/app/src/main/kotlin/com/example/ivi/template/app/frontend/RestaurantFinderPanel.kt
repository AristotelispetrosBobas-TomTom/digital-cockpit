package com.example.ivi.template.app.frontend

import com.tomtom.ivi.platform.frontend.api.common.frontend.FrontendContext
import com.tomtom.ivi.platform.frontend.api.common.frontend.IviFragment
import com.tomtom.ivi.platform.frontend.api.common.frontend.panels.TaskPanel

internal class RestaurantFinderPanel(frontendContext: FrontendContext) :
    TaskPanel(frontendContext) {
    override fun createInitialFragmentInitializer() =
        IviFragment.Initializer(RestaurantFinderFragment(), this)
}
