object AppConfig {
    private const val applicationName = "ComposeSample"
    const val applicationId = "com.example.composesample"

    const val buildToolsVersion = "32.0.0"

    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33

    const val versionCode = AppVersion.versionCode
    const val versionName =
        "$applicationName ${AppVersion.majorVersion}.${AppVersion.minorVersion}${AppVersion.stage}.${AppVersion.patchVersion}"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
}