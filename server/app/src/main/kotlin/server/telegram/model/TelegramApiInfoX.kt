package server.telegram.model

data class TelegramApiInfoX(
    val apiHash: String,
    val apiId: Int,
    val appVersion: String,
    val langCode: String,
    val model: String,
    val phoneNumber: String,
    val sysVer: String
)