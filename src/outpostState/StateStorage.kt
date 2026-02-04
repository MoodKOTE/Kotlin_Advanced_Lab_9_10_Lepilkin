package outpostState

import java.io.File
import java.io.IOException

object StateStorage {
    private const val FILE_NAME = "resources_state.txt"

    fun saveResources(resources: List<ObservableResource>) {
        val content = resources.joinToString("\n") { "${it.name}=${it.amount}" }
        File(FILE_NAME).writeText(content)
        println("Состояние сохранено в файл '$FILE_NAME'")
    }

    fun loadResources(): List<ObservableResource> {
        val file = File(FILE_NAME)

        if (!file.exists()) {
            println("Файл состояния не найден")
            return emptyList()
        }

        val loadedResources = mutableListOf<ObservableResource>()

        file.readLines().forEach { line ->
            val parts = line.split("=")
            if (parts.size == 2) {
                val name = parts[0]
                val amount = parts[1].toInt()
                val resource = ObservableResource(name)
                resource.amount = amount
                loadedResources.add(resource)
            }
        }

        println("Состояние загружено из файла '$FILE_NAME'")
        return loadedResources
    }
}