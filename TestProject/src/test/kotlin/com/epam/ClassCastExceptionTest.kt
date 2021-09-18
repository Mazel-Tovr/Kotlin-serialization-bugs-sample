package com.epam

import kotlinx.serialization.json.*
import kotlin.test.*

class ClassCastExceptionTest {

    //Class cast exception
    @Test
    fun test() {
        val a = POJO(listOf(Method("1", "2", "3", "gfd")))
        Json.encodeToJsonElement(a)
    }

}
