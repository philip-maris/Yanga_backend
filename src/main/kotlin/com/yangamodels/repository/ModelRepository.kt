package com.yangamodels.repository

import com.yangamodels.entity.YangaModel
import com.yangamodels.entity.YangaModelDto

interface ModelRepository {

    fun getAllModels() : List<YangaModel>

    fun getModelById(id : Int ) : YangaModel?

    fun addModel(modelDto : YangaModelDto) : YangaModel

    fun deleteModel(id : Int ) : Boolean

    fun updateModel(id : Int , modelDto : YangaModelDto ) : Boolean
}