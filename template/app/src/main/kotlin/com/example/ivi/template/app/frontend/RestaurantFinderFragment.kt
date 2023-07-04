package com.example.ivi.template.app.frontend

import com.example.ivi.template.app.databinding.TtiviRestaurantFinderFragmentBinding
import com.tomtom.ivi.platform.frontend.api.common.frontend.IviFragment

internal class RestaurantFinderFragment :
    IviFragment<RestaurantFinderPanel, RestaurantFinderViewModel>(RestaurantFinderViewModel::class) {

    override val viewFactory = ViewFactory(TtiviRestaurantFinderFragmentBinding::inflate)
}
