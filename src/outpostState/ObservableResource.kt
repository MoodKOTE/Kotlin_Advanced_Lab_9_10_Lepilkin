package outpostState

import kotlin.properties.Delegates

class ObservableResource(val name: String) {
    var amount: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("Ресурс $name изменён: $oldValue → $newValue")
        observers.forEach { it.onResourceChanged(this, oldValue, newValue) }
    }

    private val observers = mutableListOf<ResourceObserver>()

    fun addObserver(observer: ResourceObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: ResourceObserver) {
        observers.remove(observer)
    }

    override fun toString(): String = "$name: $amount"
}