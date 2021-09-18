package com.epam

import kotlinx.serialization.*

// Uncomment 9 line to reproduce compilation exception
@Serializable
data class StoredClassData(
    @Id val version: String,
//    @StreamSerialization("KRYO", 0, ["com.epam.kodux.Method"])
    val data: ClassData,
)

@Serializable
data class POJO(
    @StreamSerializationNew(SerializationType.KRYO, CompressType.ZSTD, ["com.epam.kodux.Method"])
    val method: List<Method>,
)

@Serializable
data class ClassData(
    @Id val buildVersion: String,
    val packageTree: PackageTree = PackageTree(),
    val methods: List<Method> = emptyList(),
    val probeIds: Map<String, Long> = emptyMap(),
)

@Serializable
data class PackageTree(
    val totalCount: Int = 0,
    val totalMethodCount: Int = 0,
    val totalClassCount: Int = 0,
    val packages: List<JavaPackageCoverage> = emptyList(),
)

@Serializable
data class JavaPackageCoverage(
    val id: String,
    val name: String,
    val totalClassesCount: Int = 0,
    val totalMethodsCount: Int = 0,
    val totalCount: Int = 0,
    val coverage: Double = 0.0,
    val coveredClassesCount: Int = 0,
    val coveredMethodsCount: Int = 0,
    val assocTestsCount: Int = 0,
    val classes: List<JavaClassCoverage> = emptyList(),
)

@Serializable
data class JavaClassCoverage(
    val id: String,
    val name: String,
    val path: String,
    val totalMethodsCount: Int = 0,
    val totalCount: Int = 0,
    val coverage: Double = 0.0,
    val coveredMethodsCount: Int = 0,
    val assocTestsCount: Int = 0,
    val methods: List<JavaMethodCoverage> = emptyList(),
    val probes: List<Int> = emptyList(),
)

@Serializable
data class JavaMethodCoverage(
    val id: String,
    val name: String,
    val desc: String,
    val decl: String,
    val count: Int,
    val coverage: Double = 0.0,
    val assocTestsCount: Int = 0,
)

@Serializable
data class Method(
    val ownerClass: String,
    val name: String,
    val desc: String,
    val hash: String,
)
