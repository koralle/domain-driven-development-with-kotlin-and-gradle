package chapter6

interface IUserRepository {
    fun find(id: UserId): User?
    fun find(name: UserName): User?
    fun save(user: User)
    fun delete(user: User)
}
