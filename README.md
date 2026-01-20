# Лабораторная работа №9-10: Продвинутое ООП на Kotlin

## Описание
Лабораторная работа посвящена изучению продвинутых концепций объектно-ориентированного
программирования в Kotlin.

## Структура проекта
Проект содержит примеры реализации продвинутых механизмов ООП, а также пояснения к ключевым
концепциям.

## Как запустить проект
1. Клонируем репозиторий:
```bash
git clone <URL_репозитория>
```
2. Откройте проект в Intellij IDEA.
3. Запустите любой пример через контекстное меню или напрямую из 'main'.

## Геттеры и сеттеры
Геттеры и сеттеры позволяют контролировать доступ к свойствам класса. В Kotlin они могут быть пользовательскими.
```bash
class Hero(val name: String) {
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }
    
    var stamina: Int = 50
        get() = field + 10
}
```

## Инкапсуляция
Инкапсуляция - это сокрытие внутренней реализации объекта и предоставление контролируемого доступа к данным.
```bash
class OutpostWorker(val name: String) {
    var maxEnergy: Int = 100
        private set
    
    var level: Int = 1
        private set
    
    fun levelUp() {
        level++
        maxEnergy += 20
    }
}
```
## Data-классы
Data-классы автоматически генерируют полезные методы: toString(), equals(), hashCode(), copy() и componentN().
```bash
data class OutpostResource(
    val id: Int,
    val name: String,
    val amount: Int
)

fun main() {
    val gas = OutpostResource(1, "Gas", 100)
    val bonusGas = gas.copy(amount = gas.amount + 50)
    println(bonusGas) 
}
```
## Абстрактные классы
Абстрактные классы не могут быть инстанциированы напрямую и могут содержать как абстрактные, так и реализованные методы.
```bash
abstract class OutpostModule(val name: String, var level: Int = 1) {
    fun upgrade() {
        level++
        println("$name улучшен до уровня $level")
    }
    
    abstract fun performAction(manager: ResourceManager)
}

class EnergyGenerator : OutpostModule("Генератор энергии") {
    override fun performAction(manager: ResourceManager) {
    }
}
```
## Интерфейсы
Интерфейсы - это контракт поведения. Содержат:
- функции без реализации
- функции с default-реализацией
- свойства без хранения (только декларации)
```bash
interface VideoPlayable {
    fun play() = println("Play video")
}

interface AudioPlayable {
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<AudioPlayable>.play()
        super<VideoPlayable>.play()
    }
}
```
## Автор
Лепилкин Максим Александрович

# # Лицензия
Проект создан в учебных целях.