import kotlin.properties.Delegates

class UserProfile(initialName: String, initialEmail: String) {}

class GameHero(startName: String) {
    var name: String by Delegates.observable(initialValue = startName) {
            _, old, new ->
        println("[$old] получил новое имя: $new!")
    }
    var mana: Int by Delegates.observable(initialValue = 100) {
            _, old, new ->
        println("Мана: $old → $new")
    }
    val ultimate: String by lazy {
        println("Загружаем анимацию способности...")
        "Метеоритный дождь"
    }
}

fun main() {
    println("Создаём героя...")
    val hero = GameHero(startName = "Воин Света")

    println("\nТекущая мана: ${hero.mana}")

    println("\nГерой пытается использовать способность:")
    println("Способность: ${hero.ultimate}")

    println("\nПовторный вызов способности (должна быть мгновенной):")
    println("Способность: ${hero.ultimate}")

    println("\nМеняем имя героя:")
    hero.name = "Тёмный Паладин"

    println("\nГерой восстанавливает ману:")
    hero.mana = 200
}