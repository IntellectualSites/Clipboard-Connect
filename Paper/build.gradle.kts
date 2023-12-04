import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    kotlin("jvm") version "1.9.20"
    alias(libs.plugins.paper.yml)
}

group = "net.onelitefeather"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
kotlin {
    jvmToolchain(17)
}

paper {
    main = "net.onelitefeather.clipoardconnect.ClipboardConnect"
    apiVersion = "1.19"
    authors = listOf("TheMeinerLP", "OneLiteFeatherNET")

    serverDependencies {
        // During server run time, require LuckPerms, add it to the classpath, and load it before us
        register("WorldEdit") {
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }
}