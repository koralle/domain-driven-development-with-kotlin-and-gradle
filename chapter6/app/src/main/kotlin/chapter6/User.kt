package chapter6

// これを参考にした
// https://vtsen.hashnode.dev/understand-kotlin-multiple-constructors
class User(private val id: UserId, private var name: UserName) {
    constructor(name: UserName) : this(UserId("hogehoge"), name)
    
    public fun changeName(name: UserName) {
        this.name = name
    }
    
    fun getId(): UserId {
        return this.id
    }
    
    fun getName(): UserName {
        return this.name
    }
}
