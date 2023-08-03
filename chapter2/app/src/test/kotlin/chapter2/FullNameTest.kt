package chapter2

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class FullNameTest {
    
    @Test
    fun testEqualsFullName() {
        val firstName = Name("John")
        val lastName = Name("Doe")
        val fullName1 = FullName(firstName, lastName)
        val fullName2 = FullName(firstName, lastName)

        assertEquals(fullName1, fullName2)
    }
    
    @Test
    fun testThrowsExceptionWhenFirstNameIsEmpty() {
        val message = "FirstName must not be empty"
        assertFailsWith<IllegalArgumentException>(message) { 
            FullName(Name(""), Name("Doe")) 
        }
    }

    @Test
    fun testThrowsExceptionWhenLastNameIsEmpty() {
        val message = "LastName must not be empty"
        assertFailsWith<IllegalArgumentException>(message) { 
            FullName(Name("John"), Name("")) 
        }
    }
}
