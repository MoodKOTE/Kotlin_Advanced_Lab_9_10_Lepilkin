package gameCharacter

fun check1(status: Status){
    when(status){
        Status.Standstill -> println("Персонаж бездействует")
        Status.Run -> println("Персонаж бежит")
        is Status.Attack -> println("Персонаж атакует с уроном ${status.damage}")
        is Status.Death -> println("Персонаж погиб: ${status.deathType}")
    }
}

fun main(){
    val person = Character("Max")
    check1(person.currentState)
    person.changeState(Status.Run)
    check1(person.currentState)
    person.changeState(Status.Attack(20))
    check1(person.currentState)
    person.changeState(Status.Death("Убит наковальней"))
    check1(person.currentState)
}