/*
 * Copyright © 2021 TomTom NV. All rights reserved.
 *
 * This software is the proprietary copyright of TomTom NV and its subsidiaries and may be
 * used for internal evaluation purposes or commercial use strictly subject to separate
 * license agreement between you and TomTom NV. If you are the licensee, you are only permitted
 * to use this software in accordance with the terms of your license agreement. If you are
 * not the licensee, you are not authorized to use this software in any manner and should
 * immediately return or destroy it.
 */

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("android-extensions", iviDependencies.versions.kotlin.get()))
    implementation(iviDependencies.gradleAndroidToolsBuildGradle)
    implementation(iviDependencies.gradleAndroidToolsSdklib)
    implementation(iviDependencies.gradlePluginArtifactory)
    implementation(iviDependencies.gradlePluginKotlin)
    implementation(iviDependencies.gradlePluginKotlinSerialization)
    implementation(iviDependencies.gradlePluginKsp)
    implementation(iviDependencies.gradlePluginSonarqube)
    implementation(iviDependencies.gradlePluginNavtestAndroid)
    implementation(iviDependencies.gradlePluginNavtestCore)
    implementation(iviDependencies.gradlePluginNavappEmulators)
    implementation(iviDependencies.gradlePluginTomtomTools)
    implementation(libraries.gradlePluginApiAppsuiteDefaultsAlexa)
    implementation(libraries.gradlePluginApiAppsuiteDefaultsUserprofiles)
    implementation(libraries.gradlePluginApiProductDefaultsCore)
    implementation(libraries.gradlePluginApiFrameworksConfig)
    implementation(libraries.gradlePluginApiFrameworksFrontend)
    implementation(libraries.gradlePluginApiToolsSigningConfig)
    implementation(libraries.gradlePluginApiToolsEmulators)
}
