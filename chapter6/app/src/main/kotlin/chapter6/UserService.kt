package chapter6

class UserService(private val userRepository: IUserRepository) {
    init {

    }
    
    public fun exists(user: User): Boolean {
        val duplidatedUser = userRepository.find(user.getName())
        
        return duplidatedUser != null
    }
}
