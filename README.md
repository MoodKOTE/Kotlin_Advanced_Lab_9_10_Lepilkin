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

### Galaxy Outpost Manager
Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программированияиархитектурные приёмы языка. 
## Sealed-классы
Sealed-классы используются для представления ограниченного набора состояний или результатов, которыеизвестны на этапе компиляции. 
**Они позволяют:**
- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию when без else;
- удобно описывать состояния, события и результаты действий. 
- Пример: результат работы модуля

```kotlin
sealed-class ModuleResult {
data class Success(val message: String) : ModuleResult()
data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
data class NotEnoughResources(
    val resourceName: String, 
    val required: Int,
    val available: Int
) : ModuleResult()
data class Error(val reason: String) : ModuleResult()
}
```

## Object в Kotlin
**object** — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).
Особенности:
- создаётся при первом обращении;
- существует в одном экземпляре;
- не имеет конструктора. 
- Пример: глобальный логгер

```kotlin
object Logger {
private var counter = 0
fun log(message: String) {
    counter++
    println("[$counter] $message")
    }
}
```

**Использование:**
```kotlin
Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
```
**object** удобно использовать для:
- логгеров;
- конфигураций;
- состояний без данных в sealed-классах;
- утилитарных классов.

## Делегирование свойств 
Делегирование свойств позволяет передать логику хранения и обработки значения другому объекту. 
В Kotlin это реализуется с помощью ключевого слова by. 
Преимущества: 
- уменьшение дублирования кода;
- централизованная логика проверки и обработки данных;
- более чистый и читаемый код. 
Пример: ограничение диапазона значения энергии
```kotlin
var energy: Int by Delegates.observable(100) { _, old, new ->
println("Энергия изменилась: $old → $new")
}
```

## Lazy (ленивая инициализация)
lazy позволяет инициализировать объект только при первом обращении к нему.
Это полезно, если:
- объект создаётся не всегда;
- его создание ресурсоёмкое;
- нужно отложить инициализацию.
Пример:
```kotlin
val resourceManager by lazy {
ResourceManager()
}
```
Объект ResourceManager будет создан только при первом использовании.

## Observer-паттерн (наблюдатель)
Observer-паттерн позволяет объектам реагировать на изменения состояния другого объекта.
В проекте Galaxy Outpost Manager наблюдатели могут:
- реагировать на изменение ресурсов;
- логировать события;
- уведомлять пользователя.

Пример идеи:
ResourceManager изменяет ресурсы;
наблюдатель выводит сообщение в консоль при изменении.
Сохранение состояния
Для сохранения состояния проекта используется сериализация в JSON.
Это позволяет:
- сохранять данные между запусками программы;
- хранить состояние в человекочитаемом формате;
- легко перенести логику в Android-приложение.


## Автор
Лепилкин Максим Александрович

## Лицензия
Проект создан в учебных целях.