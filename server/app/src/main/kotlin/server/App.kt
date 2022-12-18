package server

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import server.telegram.fetchBetesebAcademyChannelMessages
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger


fun app() {
    embeddedServer(Netty, 5000) {
        routing {
            get("/telegram_feed") {


                val result = fetchBetesebAcademyChannelMessages(10)

                call.respond(result.toString())


            }
        }
    }.start(true)
}

fun main() {
    app()
}