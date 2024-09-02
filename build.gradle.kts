
plugins {
    id("java")
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
