package moe.yunfachi.yunfalib.api

import moe.yunfachi.yunfalib.YunfaLib
import java.util.*

object Update {
    val gitInfo = Properties().also {
        val inputStream = YunfaLib::class.java.classLoader.getResourceAsStream("git.properties")

        if (inputStream != null) {
            it.load(inputStream)
        } else {
            it["git.build.version"] = "unofficial"
        }
    }
}