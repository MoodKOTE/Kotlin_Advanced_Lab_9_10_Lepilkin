package gameCharacter

sealed class Status{
    object Standstill: Status()
    object Run: Status()
    data class Attack(val damage: Int): Status()
    data class Death(val deathType: String): Status()
}