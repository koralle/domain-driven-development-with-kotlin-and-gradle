package chapter6

class UserDeleteService(private val userRepository: IUserRepository) {
    fun Handle(command: UserDeleteCommand) {
        val userId = UserId(command.id)
        val user = userRepository.find(userId)
        
        if (user == null) {
            throw RuntimeException("User not found")
        }
        
        userRepository.delete(user)
    }
}
