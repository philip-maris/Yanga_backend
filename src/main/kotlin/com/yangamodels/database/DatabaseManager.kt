package com.yangamodels.database

import com.yangamodels.entity.YangaModel
import com.yangamodels.entity.YangaModelDto
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {
    private val hostname = "localhost"
    private val databaseName = "yangamodels"
    private val userName = "root"
    private val password = "12345"


    private val ktormDatabase : Database

init{
    val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$userName&password=$password"
    ktormDatabase = Database.connect(jdbcUrl)
}
    fun getAllModels(): List<DbModelsEntity> {
        return ktormDatabase.sequenceOf(DbModelsTable).toList()
    }
    fun getAllModel(id : Int): DbModelsEntity?{
        return ktormDatabase.sequenceOf(DbModelsTable).firstOrNull{ it.modelId eq id }
    }

    fun addModel(modelDto : YangaModelDto ): YangaModel{

        val insertedId =  ktormDatabase.insertAndGenerateKey(DbModelsTable){
            set(DbModelsTable.firstName , modelDto.firstName )
            set(DbModelsTable.lastName , modelDto.lastName )
            set(DbModelsTable.dateOfBirth , modelDto.dateOfBirth )
            set(DbModelsTable.email , modelDto.email )
            set(DbModelsTable.mobileNumber , modelDto.mobileNumber )
            set(DbModelsTable.address , modelDto.address )
            set(DbModelsTable.city , modelDto.city )
            set(DbModelsTable.instagram , modelDto.instagram )
            set(DbModelsTable.talentOrHobbies , modelDto.talentOrHobbies )
            set(DbModelsTable.sex , modelDto.sex )
        } as Int

        return YangaModel(insertedId, modelDto.firstName , modelDto.lastName, modelDto.dateOfBirth, modelDto.email, modelDto.mobileNumber, modelDto.address, modelDto.city, modelDto.instagram, modelDto.talentOrHobbies ,modelDto.sex )
    }

    fun updateModel(id : Int ,modelDto : YangaModelDto ): Boolean{

        val updatedRows =  ktormDatabase.update(DbModelsTable){
            set(DbModelsTable.firstName , modelDto.firstName )
            set(DbModelsTable.lastName , modelDto.lastName )
            set(DbModelsTable.dateOfBirth , modelDto.dateOfBirth )
            set(DbModelsTable.email , modelDto.email )
            set(DbModelsTable.mobileNumber , modelDto.mobileNumber )
            set(DbModelsTable.address , modelDto.address )
            set(DbModelsTable.city , modelDto.city )
            set(DbModelsTable.instagram , modelDto.instagram )
            set(DbModelsTable.talentOrHobbies , modelDto.talentOrHobbies )
            set(DbModelsTable.sex , modelDto.sex )
            where{
                it.modelId eq id
            }
        }

        return updatedRows > 0
    }
    fun deleteModel(id : Int ): Boolean{

        val deletedRows =  ktormDatabase.delete(DbModelsTable){
                it.modelId eq id
        }

        return deletedRows > 0
    }


}