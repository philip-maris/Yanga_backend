package com.yangamodels.database

import com.yangamodels.entity.Measurement
import com.yangamodels.entity.MeasurementDto
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DbModelsTable : Table<DbModelsEntity>("model_info"){

    var modelId = int ("modelId").primaryKey().bindTo{ it.modelId}
    var firstName = varchar("firstName").bindTo{ it.firstName }
    var lastName = varchar("lastName").bindTo{ it.lastName }
    var dateOfBirth = varchar("dateOfBirth").bindTo{ it.dateOfBirth }
    var email = varchar("email").bindTo{ it.email }
    var mobileNumber = int("mobileNumber").bindTo{ it.mobileNumber }
    var address = varchar("address").bindTo{ it.address }
    var city = varchar("city").bindTo{ it.city }
    var instagram = varchar("instagram").bindTo{ it.instagram }
    var talentOrHobbies = varchar("talentOrHobbies").bindTo{ it.talentOrHobbies }
    var sex = varchar("sex").bindTo{ it.sex }
//    var measurements = varchar("measurementsDto").bindTo{ it.measurementsDto }
//    var talentOrHobbies = int ("age").bindTo{ it.age }


}

interface DbModelsEntity : Entity<DbModelsEntity> {

    companion object : Entity.Factory<DbModelsEntity>()
    val modelId : Int
    var firstName : String
    var lastName : String
    var dateOfBirth : String
    var email : String
    var mobileNumber : Int
    var address : String
    var city : String
    var instagram : String
    var talentOrHobbies : String
    var sex : String
//    var measurements : Measurement
}