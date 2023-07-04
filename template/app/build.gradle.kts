/*
 * Copyright © 2021. Change this to your own official copyright statement.
 */

import com.tomtom.ivi.appsuite.gradle.appstore.api.appsuitedefaults.appstore.appStoreGroup
import com.tomtom.ivi.appsuite.gradle.bluetooth.api.appsuitedefaults.bluetooth.bluetoothGroup
import com.tomtom.ivi.appsuite.gradle.communications.api.appsuitedefaults.communications.communicationsGroup
import com.tomtom.ivi.appsuite.gradle.companionapp.api.appsuitedefaults.companionapp.companionAppGroup
import com.tomtom.ivi.appsuite.gradle.hvac.api.appsuitedefaults.hvac.hvacGroup
import com.tomtom.ivi.appsuite.gradle.media.api.appsuitedefaults.media.mediaGroup
import com.tomtom.ivi.appsuite.gradle.messaging.api.appsuitedefaults.messaging.messagingGroup
import com.tomtom.ivi.appsuite.gradle.navappcomponents.api.appsuitedefaults.navappcomponents.navAppComponentsGroup
import com.tomtom.ivi.appsuite.gradle.navigation.api.appsuitedefaults.navigation.navigationGroup
import com.tomtom.ivi.appsuite.gradle.systemstatus.api.appsuitedefaults.systemstatus.systemStatusGroup
import com.tomtom.ivi.appsuite.gradle.userprofiles.api.appsuitedefaults.userprofiles.userProfilesGroup
import com.tomtom.ivi.appsuite.gradle.vehiclesettings.api.appsuitedefaults.vehiclesettings.vehicleSettingsGroup
import com.tomtom.ivi.buildsrc.environment.ProjectAbis
import com.tomtom.ivi.platform.gradle.api.common.annotations.EXPERIMENTAL_API_USAGE
import com.tomtom.ivi.platform.gradle.api.common.dependencies.IviPlatformModuleReference
import com.tomtom.ivi.platform.gradle.api.common.dependencies.ModuleReference
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.config.IviAppsuite
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.config.IviInstanceIdentifier
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.config.IviServiceHostConfig
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.config.IviServiceInterfaceConfig
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.configurators.IviDefaultsGroupsSelectionConfigurator
import com.tomtom.ivi.platform.gradle.api.defaults.config.privacySettingsServiceHost
import com.tomtom.ivi.platform.gradle.api.framework.config.ivi
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.config.FrontendCreationPolicy
import com.tomtom.ivi.buildsrc.dependencies.ExampleModuleReference
import com.tomtom.ivi.platform.gradle.api.common.iviapplication.config.FrontendConfig

public val configurePrivacySettingsServiceHost: IviServiceHostConfig =
    IviServiceHostConfig(
        serviceHostBuilderName = "ConfigureConsentPrivacySettingsServiceHostBuilder",
        ModuleReference(
            groupName = "com.example.ivi",
            moduleName = "template_app",
            packageName = "com.example.ivi.template.app.privacysettings"
        ),
        interfaces = listOf(
            IviServiceInterfaceConfig(
                serviceName = "PrivacySettingsService",
                serviceApiModule = IviPlatformModuleReference(
                    "platform_navigation_api_service_privacysettings"
                )
            )
        )
    )

plugins {
    id("com.tomtom.ivi.product.defaults.core")
}

ivi {
    application {
        enabled = true
        iviInstances {
            create(IviInstanceIdentifier.default) {
                applyGroups {
                    selectGroups()
                }
                frontends {
                    add(restaurantFinderFrontend)
                }

                menuItems {
                    addLast(restaurantFinderMenuItem to restaurantFinderFrontend)
                }
            }
        }
        services {
            applyGroups {
                selectGroups()
            }
            @Suppress(EXPERIMENTAL_API_USAGE)
            removeHost(privacySettingsServiceHost)
            addHost(configurePrivacySettingsServiceHost)
        }
    }
}

/**
 * Selects the build time configuration groups included in the IVI application.
 *
 * __Note:__ The build time configuration group `IviPlatform.debugGroup` is only added in `debug`
 * build types.
 */
fun IviDefaultsGroupsSelectionConfigurator.selectGroups() {
    includeDefaultPlatformGroups()
    include(
        IviAppsuite.appStoreGroup,
        IviAppsuite.bluetoothGroup,
        IviAppsuite.communicationsGroup,
        IviAppsuite.companionAppGroup,
        IviAppsuite.hvacGroup,
        IviAppsuite.mediaGroup,
        IviAppsuite.messagingGroup,
        IviAppsuite.navAppComponentsGroup,
        IviAppsuite.navigationGroup,
        IviAppsuite.systemStatusGroup,
        IviAppsuite.userProfilesGroup,
        IviAppsuite.vehicleSettingsGroup
    )
}

android {
    namespace = "com.example.ivi.template.app"
    defaultConfig {
        applicationId = "com.example.ivi.template.app"
    }

    buildFeatures {
        dataBinding = true
    }

    signingConfigs.maybeCreate("release")
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    // Split the output into multiple APKs based on their ABI.
    splits.abi {
        isEnable = true
        reset()
        include(*ProjectAbis.enabledAbis)
    }
}

dependencies {
    implementation(iviDependencies.tomtomAutomotiveAndroidCar)
    implementation(libraries.iviPlatformThemingApiCommonAttributes)
    implementation(libraries.iviPlatformFrameworkApiProductDebugPermissions)
    implementation(libraries.iviPlatformFrameworkApiProductDefaultActivity)
    implementation(libraries.iviPlatformFrameworkApiProductDefaultApplication)
}

val restaurantFinderFrontend by extra {
    FrontendConfig(
        frontendBuilderName = "RestaurantFinderFrontendBuilder",
        implementationModule = ExampleModuleReference("template_app"),
        creationPolicy = FrontendCreationPolicy.CREATE_ON_DEMAND
    )
}

val restaurantFinderMenuItem by extra {
    restaurantFinderFrontend.toMenuItem("restaurantFinderMenuItem")
}
