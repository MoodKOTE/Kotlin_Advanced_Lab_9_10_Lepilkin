package modules

import resources.ResourceManager

class ResearchLab: OutpostModule("Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager): ModuleResult {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
           return ModuleResult.NotEnoughResources(
               resourcesName = "Minerals",
               required = 30,
               available = minerals?.amount ?: 0
           )
        }
        else{
            minerals.amount -= 30
            return ModuleResult.Success("Исследование завершено")
        }
    }
}