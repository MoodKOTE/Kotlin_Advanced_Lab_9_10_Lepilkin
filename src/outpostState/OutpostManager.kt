package outpostState

class OutpostManager {
    val resources: MutableList<ObservableResource> by lazy {
        println("Менеджер ресурсов создан!")
        mutableListOf()
    }

    fun addResource(resource: ObservableResource) {
        resources.add(resource)
    }

    fun getResource(name: String): ObservableResource? {
        return resources.find { it.name == name }
    }

    fun showAllResources() {
        if (resources.isEmpty()) {
            println("Ресурсов нет")
        } else {
            println("Текущие ресурсы:")
            resources.forEach { println(it) }
        }
    }
}