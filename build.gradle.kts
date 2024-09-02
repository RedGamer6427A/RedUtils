
plugins {
    id("java")
    `maven-publish`
}

group = "dev.redgamer6427a"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jetbrains:annotations:24.0.1")


}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveBaseName.set("RedUtilsTest")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("") // Leave empty if no classifier is needed

    manifest {
        attributes["Main-Class"] = "dev.redgamer6427a.Main" // Replace with your main class
    }

    from(sourceSets.main.get().output)
}
publishing {
    repositories {
        maven {
            name = "RedUtils"
            url = uri("https://maven.pkg.github.com/RedGamer6427A/RedUtils")

            credentials {
                username = "RedGamer6427A"
                password = "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"
            }
        }
    }

    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])

            // If you have a custom artifact, use this instead:
            // artifact("build/libs/your-artifact.jar")

            groupId = "dev.redgamer6427a" // Replace with your package's group ID
            artifactId = "RedUtils" // Replace with your artifact ID
            version = "1.0.2" // Replace with your package's version
        }
    }
}
