plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ru.mirea.vasilenkoya.securesharedpreferences"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.mirea.vasilenkoya.securesharedpreferences"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation	("androidx.security:security-crypto:1.0.0") //Для повышения уровня безопасности
    // хранимых данных используется класс «EncryptedSharedPreferences» из библиотеки «security-crypto»

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}