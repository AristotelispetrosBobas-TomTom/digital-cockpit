package com.example.ivi.template.app.frontend

import com.example.ivi.template.app.R
import com.tomtom.ivi.platform.mainmenu.api.common.menu.MenuItem

val restaurantFinderMenuItem = MenuItem(
    RestaurantFinderFrontend::class.qualifiedName!!,
    R.drawable.restaurant_finder_menuitem_icon,
    R.string.restaurant_finder_menuitem_name
)
