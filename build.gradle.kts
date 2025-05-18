plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "gmail.sometokens"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("com.codeborne:selenide:7.9.0")
    testImplementation("org.assertj:assertj-core:3.27.3")
    testImplementation("org.slf4j:slf4j-simple:2.0.17")
}

allure {
    report {
        version.set("2.19.0")
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.19.0")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}