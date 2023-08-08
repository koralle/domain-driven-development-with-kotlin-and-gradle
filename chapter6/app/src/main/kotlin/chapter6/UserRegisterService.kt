package chapter6

class UserRegisterService(private val userRepository: IUserRepository, private val userService: UserService) {
    fun Handle(command: UserRegisterCommand) {
        val userName = UserName(command.name)
        
        val user = User(userName)
        
        if (userService.exists(user)) {
            throw RuntimeException("User already exists")
        }
        
        userRepository.save(user)
    }
}
