/*
 * Copyright © 2023 TomTom NV. All rights reserved.
 *
 * This software is the proprietary copyright of TomTom NV and its subsidiaries and may be
 * used for internal evaluation purposes or commercial use strictly subject to separate
 * license agreement between you and TomTom NV. If you are the licensee, you are only permitted
 * to use this software in accordance with the terms of your license agreement. If you are
 * not the licensee, you are not authorized to use this software in any manner and should
 * immediately return or destroy it.
 */

package com.example.ivi.example.media.customminiplayer

import androidx.lifecycle.viewModelScope
import com.tomtom.ivi.appsuite.media.api.common.frontend.panels.MediaTaskProcessPanelBase
import com.tomtom.ivi.platform.frontend.api.common.frontend.viewmodels.FrontendViewModel

/**
 * This ViewModel replaces the stock ViewModel of the [MediaTaskProcessPanelBase].
 */
internal class CustomMediaTaskProcessViewModel(panel: MediaTaskProcessPanelBase) :
    FrontendViewModel<MediaTaskProcessPanelBase>(panel) {

    internal val customMediaCommonProcessViewModel = CustomMediaCommonProcessViewModel(
        panel.mediaFrontendContext,
        viewModelScope
    )
}
