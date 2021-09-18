package com.epam

import kotlin.test.*

class CompilationExceptionTest {

    // Uncomment 9 line of com.epam.Model.kt to reproduce compilation exception
    @Test
    fun test() {
        val id = "one"
        val a = StoredClassData(id, ClassData(
            "0.0.0",
            PackageTree(
                1,
                1,
                1,
                ArrayList<JavaPackageCoverage>().also { it2 ->
                    it2.add(
                        JavaPackageCoverage(
                            "1",
                            "1",
                            1,
                            1,
                            1,
                            1.0,
                            1,
                            1,
                            1,
                            ArrayList<JavaClassCoverage>().also { it1 ->
                                it1.add(JavaClassCoverage(
                                    "1",
                                    "3",
                                    "fdfgd",
                                    1,
                                    1,
                                    1.0,
                                    1,
                                    1,
                                    ArrayList<JavaMethodCoverage>().also {
                                        it.add(
                                            JavaMethodCoverage(
                                                "1",
                                                "31",
                                                "1",
                                                "1",
                                                0,
                                                0.0,
                                                0
                                            )
                                        )
                                    }
                                ))
                            }
                        ))
                }
            ),
            ArrayList<Method>().also {
                it.add(Method("1", "2", "3", "gfd"))
            }
        ))

        assertEquals(a.version, "0.0.0")
    }

}



