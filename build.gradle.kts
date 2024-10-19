plugins {
    java
}

tasks.named<Jar>("jar") {             
    manifest {
        attributes["Main-Class"] = "com/jh/casper/GetPeer"
    }
}
repositories {
	mavenCentral()
}

dependencies {
    implementation("network.casper:casper-java-sdk:2.7.0-BETA.2")
    implementation("io.github.oak:jsonrpc4j:1.6.1-oak")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0-rc1")
    implementation("dev.oak3:sbs4j:0.1.8")
}
