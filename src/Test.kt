data class Item(
    val id: Int,
    val name: String,
    val quantity: Int
) {
    override fun toString(): String {
        return "Id предмета: $id\nИмя: $name\nКоличество: $quantity\n"
    }
}
fun main(){
    val sword = Item(1, "Sword", 1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())
    val(id, name, quantity) = betterSword
    println("Id предмета: $id\nИмя: $name\nКоличество: $quantity\n")
}

//var age: Int = 18
//    set(value){
//        if ((value > 0) and (value < 110))
//            field = value
//    }
//
//fun main(){
//    println(age)
//    age = 45
//    println(age)
//    age = -345
//    println(age)
//}