package outpostState

fun main() {

    println("1. Создание менеджера...")
    val manager = OutpostManager()

    println("\n2. Первое обращение к менеджеру (должно создать ресурсы):")
    manager.showAllResources()

    println("\n3. Создание ресурсов...")
    val minerals = ObservableResource("Minerals")
    val gas = ObservableResource("Gas")
    val energy = ObservableResource("Energy")

    println("\n4. Подключение наблюдателей...")
    val consoleObserver = ConsoleResourceObserver()
    val alertObserver = AlertResourceObserver(threshold = 50)

    minerals.addObserver(consoleObserver)
    minerals.addObserver(alertObserver)
    gas.addObserver(consoleObserver)
    energy.addObserver(alertObserver)

    println("\n5. Добавление ресурсов в менеджер...")
    manager.addResource(minerals)
    manager.addResource(gas)
    manager.addResource(energy)

    println("\n6. Изменение количества ресурсов:")
    minerals.amount = 100
    minerals.amount = 120
    minerals.amount = 30
    gas.amount = 200
    energy.amount = 40
    energy.amount = 60

    println("\n7. Текущее состояние ресурсов:")
    manager.showAllResources()

    println("\n8. Сохранение состояния...")
    StateStorage.saveResources(manager.resources)

    println("\n9. Загрузка состояния...")
    val loadedResources = StateStorage.loadResources()

    println("\n10. Загруженные ресурсы:")
    if (loadedResources.isEmpty()) {
        println("Ресурсы не загружены")
    } else {
        loadedResources.forEach { println(it) }
    }

}