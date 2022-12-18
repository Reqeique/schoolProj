
 
 
package server.telegram

import com.github.badoualy.telegram.api.Kotlogram.getDefaultClient
import com.github.badoualy.telegram.api.TelegramApp
import com.github.badoualy.telegram.mtproto.util.MediaInput
import com.github.badoualy.telegram.mtproto.util.getAbsMediaInput
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.core.TLVector
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import com.google.gson.Gson
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import server.telegram.model.TelegramApiInfo
import java.awt.Image
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import kotlin.time.ExperimentalTime





fun fetchInfo(): TelegramApiInfo? {

    return try {
       Gson().fromJson(File("./server/telegram_info.json").readText(), TelegramApiInfo::class.java)
    } catch (e: FileNotFoundException){
       println("File: 'telegram_info.json' was not found in location ${File("./server/").absolutePath}")
       null
    }
}

val apiInfo = fetchInfo()!!.telegramApiInfo
val API_ID = apiInfo.apiId
val API_HASH = apiInfo.apiHash
val APP_VERSION = apiInfo.appVersion
val MODEL = apiInfo.model
val SYSTEM_VERSION = apiInfo.sysVer
val LANG_CODE = apiInfo.langCode
val PHONE_NUMBER = apiInfo.phoneNumber

val application = TelegramApp(API_ID, API_HASH, MODEL, SYSTEM_VERSION, APP_VERSION, LANG_CODE)

@OptIn(ExperimentalTime::class)
fun fetchBetesebAcademyChannelMessages(size: Int): List<String>? {

    
    val client = getDefaultClient(application, ApiStorage())
    try {
        val tlAbsDialogs = client.messagesGetDialogs(0, 0, TLInputPeerEmpty(), 0)

        val c = client.messagesGetHistory( getInputPeer(tlAbsDialogs), 0,0, size,0,0)
        c.chats.forEach {
            if (client.getChatPhoto(it)?.bytes != null) {
                val image = client.getChatPhoto(it)?.bytes

                val bi = ImageIO.read(ByteArrayInputStream(image!!.data))
                ImageIO.write(bi, "jpg", File("./server/tmp/image${('a'..'z').random()}.jpg"))
            }


        }
        println(c.messages.map {( it as TLMessage).message})
        return c.messages?.filterIsInstance<TLMessage>()
            ?.map {
                when {
                    it.message != null -> it.message

                    else -> "Null"
                }
            }



    } catch (e: RpcErrorException) {

        e.printStackTrace()
        return null
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    } finally {
        client.close()

    }
}



 fun main(){
    fetchBetesebAcademyChannelMessages(10)
}

 
fun getInputPeer(tlAbsDialogs: TLAbsDialogs): TLAbsInputPeer {
    val betesebAcademyPeerId = 1227729677
    val peer = tlAbsDialogs.chats.filter { chat: TLAbsChat -> chat.id == betesebAcademyPeerId }[0]
    return if (peer is TLChannel) TLInputPeerChannel(peer.id, peer.accessHash) else TLInputPeerEmpty()


}
