package com.yangamodels.repository

import com.yangamodels.database.DatabaseManager
import com.yangamodels.entity.YangaModel
import com.yangamodels.entity.YangaModelDto

class MySqlModelRepository : ModelRepository {

    private val database = DatabaseManager()

    override fun getAllModels(): List<YangaModel> {
        return database.getAllModels()
            .map{ YangaModel(it.modelId, it.firstName , it.lastName,it.dateOfBirth ,it.email ,it.mobileNumber ,it.address ,it.city ,it.instagram ,it.talentOrHobbies ,it.sex )}
    }

    override fun getModelById(id: Int): YangaModel? {
        return database.getAllModel(id)
            ?.let{YangaModel(it.modelId, it.firstName , it.lastName,it.dateOfBirth ,it.email ,it.mobileNumber ,it.address ,it.city ,it.instagram ,it.talentOrHobbies ,it.sex )}
    }

    override fun addModel(modelDto: YangaModelDto): YangaModel {
        return database.addModel(modelDto)
    }

    override fun deleteModel(id: Int): Boolean {
        return database.deleteModel(id)
    }

    override fun updateModel(id: Int, modelDto: YangaModelDto): Boolean {
        return database.updateModel(id,modelDto)
    }
}