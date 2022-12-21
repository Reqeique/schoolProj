package server

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.coroutine.updateOne
import org.litote.kmongo.eq
import org.litote.kmongo.newId
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.util.idValue
import server.telegram.fetchBetesebAcademyChannelMessageFromDB

import server.telegram.fetchBetesebAcademyChannelMessagesFromAPI


var request: Int = 0
suspend fun app() {
    embeddedServer(Netty, 5000) {

        install(ContentNegotiation){
            gson()
        }
        routing {
            get("/telegram_feed") {
                  request += 1
                when{
                    request%100 == 0 || request==1 -> {

                        val data = fetchBetesebAcademyChannelMessagesFromAPI(10)
                        val f = data?.filterNotNull()
                        call.respond(fetchBetesebAcademyChannelMessageFromDB(f))

                    }
                    else -> {
                        call.respond(fetchBetesebAcademyChannelMessageFromDB(null))
                    }

                }
                println("Requested $request times")
                call.respond(request.toString())


            }
        }
    }.start(true)
}

data class TelegramNews(@BsonId val id: Any = newId<Int>(), val message: String, val date: Int, val attachment: String)

suspend fun main() {
    app()
}