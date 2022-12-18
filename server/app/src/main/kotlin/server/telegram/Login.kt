package server.telegram

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.TelegramClient
import com.github.badoualy.telegram.tl.api.TLUser
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import server.telegram.ApiStorage
import server.telegram.application
import java.io.IOException
import java.util.*

fun login() {





    val client: TelegramClient = Kotlogram.getDefaultClient(application, ApiStorage())




    try {


        val sentCode = client.authSendCode(PHONE_NUMBER, 1)
        println("Authentication code: ")
        val code: String = Scanner(System.`in`).nextLine()


        val authorization: TLAuthorization = client.authSignIn(PHONE_NUMBER, sentCode.phoneCodeHash, code)
        val self: TLUser = authorization.user.asUser
        println("You are now signed in as " + self.firstName + " " + self.lastName + " @" + self.username)
    } catch (e: RpcErrorException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        client.close()
    }

}