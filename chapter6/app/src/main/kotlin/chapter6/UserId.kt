package chapter6

data class UserId(private val value: String) {
    init {
        require(value.isNotEmpty()) {
            "UserId must not be empty"
        }
    }
    
    override fun toString(): String {
        return this.value
    }
    
    fun getValue(): String {
        return this.value
    }
}
