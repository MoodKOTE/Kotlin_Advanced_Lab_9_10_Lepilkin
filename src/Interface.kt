interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop(){
        println("Останавливается...")
    }
}
interface Worker{
    fun work()
}
interface Student{
    fun study()
}
interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable{
    override fun play() {
        println("Start playing")
        super<AudioPlayable>.play()
        super<AudioPlayable>.play()
    }
}

class WorkingStudent(val name: String): Worker, Student{
    override fun study() = println("$name учится")
    override fun work() = println("$name работает")
}
class Car(override val model: String, override val number: String): Movable{
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(override val model: String, override val number: String): Movable{
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }
    override fun stop() = println("Приземляемся...")

}
fun main(){
    val pavel = WorkingStudent("Pavel")
    pavel.work()
    pavel.study()

    val car = Car("LADA", "123LAD")
    val aircraft = Aircraft("Boeing", "737")
    travel(car)
    travel(aircraft)
    aircraft.move()
    aircraft.stop()
}
fun travel(obj: Movable) = obj.move()