package chapter6

data class UserData(private val source: User) {
    val id: String = source.getId().getValue()
    val name: String = source.getName().getValue()
}
