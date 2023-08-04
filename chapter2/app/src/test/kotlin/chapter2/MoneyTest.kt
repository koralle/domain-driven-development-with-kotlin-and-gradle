package chapter2

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class MoneyTest {

    @Test
    fun testEqualsMoney() {
        val money1 = Money(100, "yen")
        val money2 = Money(100, "yen")

        assertEquals(money1, money2)
    }

    @Test
    fun testThrowsExceptionWhenAmountIsNegativeInteger() {
        val message = "Amount must not be negative integer"
        assertFailsWith<IllegalArgumentException>(message) {
            Money(-1, "yen")
        }
    }

    @Test
    fun testThrowsExceptionWhenCurrencyIsEmpty() {
        val message = "Currency must not be empty"
        assertFailsWith<IllegalArgumentException>(message) {
            Money(100, "")
        }
    }

    @Test
    fun testPlusOperator() {
        val money1 = Money(100, "yen")
        val money2 = Money(200, "yen")

        assertEquals(Money(300, "yen"), money1 + money2)
    }

    @Test
    fun testThrowsExceptionWhenCurrencyIsDifferent() {
        val money1 = Money(100, "yen")
        val money2 = Money(200, "dollar")
        val message = "Currency must be same"

        assertFailsWith<IllegalArgumentException>(message) {
            money1 + money2
        }
    }
}
