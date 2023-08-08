package chapter6

class UserApplicationService(private val userRepository: IUserRepository, private val userService: UserService) {
    init {
        
    }
    
    public fun register(name: String) {
        val username = UserName(name)
        val user = User(username)
        
        if (userService.exists(user)) {
            throw RuntimeException("User already exists")
        }
        
        userRepository.save(user)
    }
    
    public fun get(id: String): UserData? {
        val userId = UserId(id)
        
        val user = userRepository.find(userId)
        
        if (user == null) {
            return null
        }

        return UserData(user)
    }
    
    public fun update(command: UserUpdateCommand) {
        val targetId = UserId(command.id)
        
        val user = userRepository.find(targetId)
        
        if (user == null) {
            throw RuntimeException("User not found")
        }
        
        val name = command.name
        if (name != null) {
            val newUserName = UserName(name)
            user.changeName(newUserName)
            if (userService.exists(user)) {
                throw RuntimeException("User already exists")
            }
        }
        
        userRepository.save(user)
    }
    
    public fun delete(command: UserDeleteCommand) {
        val targetId = UserId(command.id)
        
        val user = userRepository.find(targetId)
        
        if (user == null) {
            throw RuntimeException("User not found")
        }
        
        userRepository.delete(user)
    }
}
