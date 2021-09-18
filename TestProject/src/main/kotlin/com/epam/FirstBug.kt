package com.epam

import kotlinx.serialization.*

@SerialInfo
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class Id

@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class StreamSerialization(
    val serializationType: String,
    val compressType: Int,
    val poolRegistration: Array<String> = [],
)
