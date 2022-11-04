plugins {
    id ("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlinx.kover") version Versions.KOTLIN_KOVER
    id("kotlin-parcelize")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isTestCoverageEnabled = true
            buildConfigField ("String", "HOST_API", "\"https://www.thecocktaildb.com\"")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            val options = this
            options.jvmTarget = "1.8"
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-Xjvm-default=all",
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
                "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
                "-Xopt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi",
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
            ) // Only required for 2.x.
        }

        kapt {
            correctErrorTypes = true
        }

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
        }

        packagingOptions {
            resources.excludes.add("META-INF/*")
            resources.excludes.add("META-INF/licenses/**")
            resources.excludes.add("META-INF/AL2.0")
            resources.excludes.add("META-INF/LGPL2.1")
            resources.excludes.add("**/attach_hotspot_windows.dll")
            resources.excludes.add("META-INF/DEPENDENCIES")
            resources.excludes.add("build-data.properties")
        }
    }
}

dependencies {
    //Modules
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.MATERIAL_DESIGN)

    implementation(Libs.LANDSCAPIST)

    //Coil
    implementation(Libs.COIL)

    //Base
    implementation(Libs.APP_COMPAT)
    implementation(Libs.CORE_KTX)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.ROUNDED_IMAGEVIEW)

    //Lifecycle
    implementation(Libs.LIFECYCLE_COMPOSE)
    kapt(Libs.LIFECYCLE_KAPT)
    implementation(Libs.LIFECYCLE_LIVEDATA)
    implementation(Libs.LIFECYCLE_PROCESSLIFECYCLEOWNER)
    implementation(Libs.LIFECYCLE_RUNTIME)
    implementation(Libs.LIFECYCLE_VIEWMODEL)

    //Lottie
    implementation(Libs.LOTTIE)

    //Compose
    implementation(Libs.ACTIVITY_COMPOSE)
    implementation(Libs.COMPOSE_ACCOMPANIST)
    implementation(Libs.COMPOSE_ACCOMPANIST_DRAWABLE_PAINTER)
    implementation(Libs.COMPOSE_ACCOMPANIST_UI)
    implementation(Libs.COMPOSE_ACCOMPANIST_PAGER)
    implementation(Libs.COMPOSE_ACCOMPANIST_PAGER_INDICATOR)
    implementation(Libs.COMPOSE_ACCOMPANIST_SYSTEM_UI)
    implementation(Libs.COMPOSE_ACCOMPANIST_PERMISSIONS)
    implementation(Libs.COMPOSE_CONSTRAINT)
    implementation(Libs.COMPOSE_UI)
    implementation(Libs.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Libs.COMPOSE_MATERIAL)
    implementation(Libs.COMPOSE_PAGING)
    implementation(Libs.COMPOSE_RUNTIME)
    implementation(Libs.COMPOSE_NAVIGATION)

    //Coroutines
    implementation(Libs.COROUTINES)

    //Dagger Hilt
    implementation(Libs.DAGGER_HILT)
    implementation(Libs.DAGGER_HILT_ANDROID_PLUGIN)
    implementation(Libs.DAGGER_HILT_COMPOSE)
    kapt(Libs.DAGGER_HILT_COMPILER)

    //Flow
    testImplementation(Libs.TURBINE)

    //Glide
    implementation(Libs.GLIDE)
    kapt(Libs.GLIDE_KAPT)

    // Local unit tests
    androidTestImplementation(Libs.ANDROID_TEST_CORE)
    androidTestImplementation(Libs.ANDROID_TEST_CORE_KTX)
    androidTestUtil(Libs.ANDROID_TEXT_ORCHESTRATOR)
    androidTestImplementation(Libs.ANDROID_TEST_RUNNER)
    androidTestImplementation(Libs.COMPOSE_UI_TEST_JUNIT)
    debugImplementation(Libs.COMPOSE_UI_TEST_MANIFEST)
    androidTestImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.JUNIT_ESPRESSO)
    androidTestImplementation(Libs.JUNIT_EXT)
    androidTestImplementation(Libs.JUNIT_KTX)
    testImplementation(Libs.ASSERTJ)
    testImplementation(Libs.MOCKITO_CORE)
    testImplementation(Libs.MOCKITO_KOTLIN)
    testImplementation(Libs.MOCKK)
    testImplementation(Libs.POWER_MOCK)
    testImplementation(Libs.LIVEDATA_TEST)
    testImplementation(Libs.MOCKK_AGENT)
    androidTestImplementation(Libs.ASSERTJ)
    androidTestImplementation(Libs.MOCKITO_CORE)
    androidTestImplementation(Libs.MOCKK_ANDROID)
    androidTestImplementation(Libs.MOCKK_AGENT)
    androidTestImplementation(Libs.LIVEDATA_TEST)
    androidTestImplementation(Libs.NAVIGATION_TEST)
    androidTestImplementation(Libs.DAGGER_HILT_TESTING)
    kaptAndroidTest(Libs.DAGGER_HILT_COMPILER)
    testImplementation(Libs.COROUTINES_TEST)

    testImplementation(Libs.DAGGER_HILT_TESTING)
    kaptTest(Libs.DAGGER_HILT_COMPILER)
    testAnnotationProcessor(Libs.DAGGER_HILT_COMPILER)

    //Navigation
    implementation(Libs.NAVIGATION_COMPOSE)
    implementation(Libs.NAVIGATION_UI)
    implementation(Libs.NAVIGATION_FEATURE)
    implementation(Libs.NAVIGATION_FRAGMENT)

    //Retrofit
    api(Libs.MOSHI_CONVERTER)
    api(Libs.OKHTTP)
    api(Libs.RETROFIT)

    //picasso
    implementation(Libs.PICASSO)
    implementation(Libs.PICASSO_TRANSFORMATION)

    //Moshi
    api(Libs.MOSHI)
    api(Libs.MOSHI_KOTLIN)
    kapt(Libs.MOSHI_KAPT)

    //Timber
    implementation(Libs.TIMBER)

    //Spinner date picker
    implementation(Libs.SPINNER_DATE_PICKER)
    implementation(Libs.JODA_TIME)

    //Only month and year date picker
    implementation ("com.github.DogusTeknoloji:compose-date-picker:1.0.1")

    implementation("androidx.annotation:annotation-experimental:1.3.0")

    implementation("com.google.code.gson:gson:2.9.1")
}