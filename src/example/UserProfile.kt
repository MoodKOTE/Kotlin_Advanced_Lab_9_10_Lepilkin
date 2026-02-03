package example

import kotlin.properties.Delegates

class UserProfile(initialName: String, initialEmail: String) {
    var name: String by Delegates.observable(initialName) { _, old, new ->
        println("Имя изменено: '$old' -> '$new'")
    }

    var email: String by Delegates.observable(initialEmail) { _, old, new ->
        println("Email изменено: '$old' -> '$new'")
    }

    val avatar: String by lazy {
        println("Загружается аватар для $name...")
        "avatar_of_$name.png"
    }
}

fun main() {
    println("Создаём профиль пользователя...")
    val user = UserProfile("Алиса", "alice@example.com")

    println("\nИмя: ${user.name}")
    println("Email: ${user.email}")

    println("\nОбращаемся к аватару впервые:")
    println("Файл аватара: ${user.avatar}")

    println("\nОбращаемся к аватару снова (должен быть взят из кэша):")
    println("Файл аватара: ${user.avatar}")  // Убрал лишний дефис

    println("\nМеняем email:")
    user.email = "alice_new@example.org"  // Убрал лишние пробелы

    println("\nМеняем имя:")
    user.name = "Алиса К."
}