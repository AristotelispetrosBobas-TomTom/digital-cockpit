package com.example.ivi.template.app.frontend

import com.example.ivi.template.app.databinding.TtiviRestaurantFinderListFragmentBinding
import com.tomtom.ivi.platform.frontend.api.common.frontend.IviFragment

internal class RestaurantFinderListFragment :
    IviFragment<RestaurantFinderListPanel, RestaurantFinderListViewModel>(RestaurantFinderListViewModel::class) {

    override val viewFactory = ViewFactory(TtiviRestaurantFinderListFragmentBinding::inflate)
}
