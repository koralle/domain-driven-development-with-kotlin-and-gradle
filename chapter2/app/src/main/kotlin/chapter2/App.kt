/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package chapter2

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val firstName = Name("John")
    var lastName = Name("Doe")
    println(FullName(firstName, lastName))
}
