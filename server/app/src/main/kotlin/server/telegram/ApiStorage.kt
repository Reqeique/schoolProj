package server.telegram

import com.github.badoualy.telegram.api.TelegramApiStorage
import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


class ApiStorage : TelegramApiStorage {
    override fun saveAuthKey(authKey: AuthKey) {
        try {
            FileUtils.writeByteArrayToFile(AUTH_KEY_FILE, authKey.key)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun loadAuthKey(): AuthKey? {
        try {
            return AuthKey(FileUtils.readFileToByteArray(AUTH_KEY_FILE))
        } catch (e: IOException) {
            if (e !is FileNotFoundException) e.printStackTrace()
        }
        return null
    }

    override fun saveDc( dataCenter: DataCenter) {
        try {
            FileUtils.write(NEAREST_DC_FILE, dataCenter.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun saveServerSalt(salt: Long) {
        print(salt)
    }


    override fun loadDc(): DataCenter? {
        try {
            val infos: List<String> = FileUtils.readFileToString(NEAREST_DC_FILE).split(":")
            return DataCenter(infos[0], infos[1].toInt())
        } catch (e: IOException) {
            if (e !is FileNotFoundException) e.printStackTrace()
        }
        return null
    }

    override fun loadServerSalt(): Long? {

        return null
    }

    override fun deleteAuthKey() {
        try {
            FileUtils.forceDelete(AUTH_KEY_FILE)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun deleteDc() {
        try {
            FileUtils.forceDelete(NEAREST_DC_FILE)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    companion object {
        //Create File variable for auth.key and dc.save
        val AUTH_KEY_FILE: File = File("Properties/auth.key")
        val NEAREST_DC_FILE: File = File("Properties/dc.save")
    }
}