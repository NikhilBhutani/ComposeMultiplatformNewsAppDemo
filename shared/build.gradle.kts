plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            export(libs.mokoCore)
            export(libs.mokoFlow)
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
//            implementation(libs.jet)

            implementation(libs.koinCore)
            implementation(libs.koinTest)

            api(libs.mokoCore)
            api(libs.mokoFlow)
            api(libs.mokoCompose)

            implementation(libs.ktorClientCore)
            implementation(libs.ktorClientLogging)
            implementation(libs.ktorClientLogging)
            implementation(libs.ktorContentNegotiation)

            implementation(libs.ktorJsonSerialization)
            implementation(libs.kotinxSerializationJson)
            implementation(libs.kotinxSerializationCore)

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenModel)
            implementation(libs.voyager.transitions)
            implementation(libs.kermit)

            api(libs.imageLoader)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.ktorClientAndroid)
            implementation(libs.koinAndroid)
            implementation(libs.sqldelightAndroid)
        }

        iosMain.dependencies {
            implementation(libs.ktorClientDarwin)
            implementation(libs.sqldelightNativeDriver)
        }
    }
}

android {
    namespace = "com.niko.kmm.newsappdemocomposemultiplatform"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("NewsAppDatabase") {
            packageName.set("com.niko.kmm.newsappdemocomposemultiplatform.data.database")
        }
    }
}