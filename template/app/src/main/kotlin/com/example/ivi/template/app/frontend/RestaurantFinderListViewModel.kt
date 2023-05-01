package com.example.ivi.template.app.frontend

import androidx.lifecycle.MutableLiveData
import com.example.ivi.template.app.service.Restaurant
import com.tomtom.ivi.platform.frontend.api.common.frontend.viewmodels.FrontendViewModel

internal class RestaurantFinderListViewModel(panel: RestaurantFinderListPanel) :
    FrontendViewModel<RestaurantFinderListPanel>(panel) {

    val listOfRestaurants = MutableLiveData(listOf(Restaurant("De Bazel")))
}
