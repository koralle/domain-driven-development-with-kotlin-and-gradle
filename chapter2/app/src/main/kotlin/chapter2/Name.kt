package chapter2

/**
 * 何かしらの名前を表現する値オブジェクト
 */
data class Name(private val value: String) {

    /**
     * @throws IllegalArgumentException 空文字の場合に例外を投げる
     * @throws IllegalArgumentException アルファベット以外の文字列で初期化された場合に例外を投げる
     */
    init {
        require(value.isNotEmpty()) {
            "Name must not be empty"
        } 
        
        require(validateName(value)) {
            "Name must be alphabet"
        }
    }
    
    /**
     * @param[value] バリデーション対象の文字列
     * @return バリデーション結果
     */
    private fun validateName(value: String): Boolean {
        val pattern = "^[a-zA-Z]+$"
        
        // 正規表現にマッチするかどうかだけ知りたいなら、Regex(pattern).containsMatchIn()で充分
        // @see https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/contains-match-in.html
        return Regex(pattern).containsMatchIn(value)
    }
    
    override fun toString(): String {
        return value
    }
}
