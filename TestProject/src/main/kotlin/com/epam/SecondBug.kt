package com.epam

import kotlinx.serialization.*


@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class StreamSerializationNew(
    val serializationType: SerializationType,
    val compressType: CompressType,
    val poolRegistration: Array<String> = [],
)

enum class SerializationType {
    FST, KRYO
}

enum class CompressType {
    NONE, ZSTD
}
