package gameCharacter

class Character(val name: String, ) {
    var currentState: Status = Status.Standstill

    fun changeState(newState: Status){
        currentState = newState
    }
}