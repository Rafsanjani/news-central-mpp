plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.2.0-alpha08"

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.foreverrafs.newscentral"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = "11"

        freeCompilerArgs =
            freeCompilerArgs + "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"
        freeCompilerArgs =
            freeCompilerArgs + "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi"

        freeCompilerArgs =
            freeCompilerArgs + "-Xopt-in=androidx.compose.ui.graphics.ExperimentalGraphicsApi"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources {
            excludes += listOf(
                "/META-INF/{AL2.0,LGPL2.1}",
            )
        }
    }
}

dependencies {
    implementation(project(":shared"))
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$composeVersion")

    // Material Design
    implementation("androidx.compose.material:material:$composeVersion")

    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    testImplementation("org.assertj:assertj-core:3.22.0")
    androidTestImplementation("org.assertj:assertj-core:3.22.0")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("io.coil-kt:coil-compose:2.0.0-rc03")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
}