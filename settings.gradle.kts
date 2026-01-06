pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.juspay.in/jp-build-packages/hyper-sdk/")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "hypersdk.plugin") {
                useModule("in.juspay:hypersdk.plugin:${requested.version}")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.juspay.in/jp-build-packages/hyper-sdk/")
    }
}

rootProject.name = "HDFCSmartGatewayDemoAndroid"
include(":app")
 