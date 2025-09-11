plugins {
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass = "org.example.hexlet.HelloWorld"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.3.232")
    implementation("org.postgresql:postgresql:42.7.4")
    implementation("org.postgresql:postgresql:42.7.4")
    implementation("com.zaxxer:HikariCP:6.3.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    implementation("org.apache.commons:commons-text:1.13.1")
    implementation("gg.jte:jte:3.2.0")
    implementation("org.slf4j:slf4j-simple:2.0.17")
    implementation("io.javalin:javalin:6.6.0")
    implementation("io.javalin:javalin-bundle:6.6.0")
    implementation("io.javalin:javalin-rendering:6.6.0")
    testImplementation("org.assertj:assertj-core:3.27.3")
    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("org.webjars:bootstrap:5.3.0")
    implementation("com.h2database:h2:2.2.220")
    implementation("com.zaxxer:HikariCP:5.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    shadowJar {
        archiveBaseName.set("hexlet-javalin-2")
        archiveVersion.set("1.0-SNAPSHOT")
        archiveClassifier.set("all")
        mergeServiceFiles()
    }

    build {
        dependsOn(shadowJar)
    }
}