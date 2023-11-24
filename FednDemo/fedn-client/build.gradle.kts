plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("plugin.serialization").version("1.8.20")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val ktorVersion: String by project
val googleProtobufVersion: String by project
val grpcKotlinStubVersion: String by project
val grpcProtobufVersion: String by project
val grpcOkhttpVersion: String by project

dependencies{
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("com.google.protobuf:protobuf-kotlin:$googleProtobufVersion")
    implementation("io.grpc:grpc-kotlin-stub:$grpcKotlinStubVersion")
    implementation("io.grpc:grpc-protobuf:$grpcProtobufVersion")
    implementation("io.grpc:grpc-okhttp:$grpcOkhttpVersion")
}