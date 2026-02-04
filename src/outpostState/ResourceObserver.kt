package outpostState

interface ResourceObserver {
    fun onResourceChanged(resource: ObservableResource, oldValue: Int, newValue: Int)
}

class ConsoleResourceObserver : ResourceObserver {
    override fun onResourceChanged(resource: ObservableResource, oldValue: Int, newValue: Int) {
        val change = newValue - oldValue
        val direction = if (change > 0) "↑ +$change" else "↓ $change"
        println("[Наблюдатель] Ресурс '${resource.name}' изменился: $direction")
    }
}

class AlertResourceObserver(private val threshold: Int) : ResourceObserver {
    override fun onResourceChanged(resource: ObservableResource, oldValue: Int, newValue: Int) {
        if (newValue < threshold) {
            println("[Тревога!] Ресурс '${resource.name}' опустился ниже $threshold (теперь: $newValue)")
        }
    }
}