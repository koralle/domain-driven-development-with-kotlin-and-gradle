package chapter2

/**
 * フルネームを表現する値オブジェクト
 */
data class FullName(private val firstName: Name, private val lastName: Name) {
    
    override fun toString(): String {
        return "$firstName $lastName"
    }
}
