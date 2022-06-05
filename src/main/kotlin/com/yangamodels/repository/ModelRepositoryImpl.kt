
package com.yangamodels.repository

/*
import com.yangamodels.entity.YangaModel
import com.yangamodels.entity.YangaModelDto

class ModelRepositoryImpl : ModelRepository {
    val models = mutableListOf<YangaModel>(
        YangaModel(1,"miles", 10),
        YangaModel(2,"john", 11)
    )
    override fun getAllModels(): List<YangaModel> = models

    override fun getModelById(id: Int): YangaModel? {
        return models.firstOrNull { it.id == id }
    }

    override fun addModel(modelDto: YangaModelDto): YangaModel {
        val model = YangaModel(
           id = models.size + 1,
            name = modelDto.name,
            age = modelDto.age
        )
        models.add(model)
        return model
    }

    override fun deleteModel(id: Int): Boolean {
      return  models.removeIf { it.id == id }
    }

    override fun updateModel(id: Int, modelDto: YangaModelDto): Boolean {
        var model = models.firstOrNull{ it.id == id }
            ?: return false

        model.name = modelDto.name
        model.age = modelDto.age
        return true
    }
}*/
