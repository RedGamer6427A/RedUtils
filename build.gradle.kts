import org.gradle.tooling.model.gradle.GradlePublication

plugins {
    id("java")
    id("maven-publish")


}

group = "dev.redgamer6427a"
version = "1.0.0"

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
    archiveBaseName.set("RedUtils")
    archiveVersion.set("1.0.0") // Ensure this version matches the one you're publishing
    archiveClassifier.set("") // Leave empty if no classifier is necessary


    from(sourceSets.main.get().output)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/redgamer6427a/RedUtils")
            credentials {
                username = "redgamer6427a"
                password = "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"
            }
        }
    }
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])

            groupId = "dev.redgamer6427a"
            artifactId = "redutils"
            version = "1.0.2"


            // Optionally customize POM
            pom {
                name.set("RedUtils")
                description.set("My own Utility Library")
                url.set("https://github.com/redgamer6427a/RedUtils")
                licenses {
                    license {
                        name.set("RedUtils License")
                        url.set("https://github.com/RedGamer6427A/RedUtils/blob/master/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("redgamer6427a")

                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/redgamer6427a/RedUtils.git")
                    developerConnection.set("scm:git:ssh://github.com:redgamer6427a/RedUtils.git")
                    url.set("https://github.com/redgamer6427a/RedUtils")
                }
            }
        }

    }
}
