package chapter6

data class UserName(private val value: String) {
    init {
        require(value.isNotEmpty()) {
            "UserName must not be empty"
        }
        
        require(value.length >=3) {
            "UserName must be at least 3 characters"
        }
        
        require(value.length <= 20) {
            "UserName must be at most 20 characters"
        }
    }
    
    fun getValue(): String {
        return this.value
    }
}
