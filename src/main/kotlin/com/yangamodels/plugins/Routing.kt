package com.yangamodels.plugins


import com.yangamodels.entity.YangaModelDto
import com.yangamodels.repository.ModelRepository
import com.yangamodels.repository.MySqlModelRepository
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.webjars.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {


    install(Webjars) {
        path = "/webjars" //defaults to /webjars
    }

    val repository : ModelRepository = MySqlModelRepository()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/models") {
            call.respond(repository.getAllModels())
        }
        get("/model/{id}") {
            val id = call.parameters["id"]?.toInt()
            if (id == null){
                call.respond(HttpStatusCode.BadRequest , "Wrong parameter")
                return@get
            }
            val model = repository.getModelById(id)

            if (model == null){
                call.respond(HttpStatusCode.NotFound , "found no model with the id $id ")
                return@get
            }else call.respond(model)

        }

        post("/newModel"){
            val modelDto = call.receive<YangaModelDto>()
            val model = repository.addModel(modelDto)
            call.respond(model)
        }

        put("/model/{id}") {
            val modelDto = call.receive<YangaModelDto>()
            val id = call.parameters["id"]?.toInt()
            if (id == null){
                call.respond(HttpStatusCode.BadRequest , "Wrong parameter")
                return@put
            }
            val updated = repository.updateModel(id, modelDto)

            if (updated){
                call.respond(HttpStatusCode.OK)
            }else {
                call.respond(HttpStatusCode.NotFound , "found no model with the id $id ")
            }

        }

        delete("/model/{id}") {
            val id = call.parameters["id"]?.toInt()
            if (id == null){
                call.respond(HttpStatusCode.BadRequest , "Wrong parameter")
                return@delete
            }
            val removed = repository.deleteModel(id)

            if (removed){
                call.respond(HttpStatusCode.OK)
            }else {
                call.respond(HttpStatusCode.NotFound , "found no model with the id $id ")
            }
        }
        get("/webjars") {
            call.respondText("<script src='/webjars/jquery/jquery.js'></script>", ContentType.Text.Html)
        }
    }
}
