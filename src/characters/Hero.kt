package characters

class Hero (val name: String){
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }

    var stamina: Int = 50
        get() = field + 10

    var level: Int = 1
    private set

    fun levelUp(){
        level++
        println("$name повыстл уровень до $level!")
    }
}

fun main(){
    val hero = Hero(name= "Утер")
    hero.health = 150
//    hero.level = 10
    hero.levelUp()
    println(hero.health)
    println(hero.stamina)
}