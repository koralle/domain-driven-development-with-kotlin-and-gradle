package chapter2

/**
 * お金を表現する値オブジェクト
 * @property amount 金額
 * @property currency 通貨単位
 */
data class Money(private val amount: Int, private val currency: String) {
    /**
     * @throws IllegalArgumentException amountが負の整数の時に例外を投げる
     * @throws IllegalArgumentException currencyが空文字列の時に例外を投げる
     */
    init {
        require(amount >= 0) {
            "Amount must not be negative"
        }
        
        require(currency.isNotEmpty()) {
            "Currency must not be empty"
        }
    }
    
    operator fun plus(other: Money): Money {
        require(currency == other.currency) {
            "Currency must be same"
        }
        
        return Money(amount + other.amount, currency)
    }

    override fun toString(): String {
        return "$amount $currency"
    }
}
