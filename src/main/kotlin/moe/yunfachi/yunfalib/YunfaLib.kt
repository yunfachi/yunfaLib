package moe.yunfachi.yunfalib

import moe.yunfachi.yunfalib.api.Update.gitInfo
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import kotlin.system.exitProcess

object YunfaLib : ModInitializer {
    const val MOD_NAME = "yunfaLib"
    const val MOD_AUTHOR = "yunfachi"

    val MOD_VERSION = gitInfo["git.build.version"]?.toString() ?: "unknown"
    val MOD_COMMIT = gitInfo["git.commit.id.abbrev"]?.let { "git-$it" } ?: "unknown"
    val MOD_BRANCH = gitInfo["git.branch"]?.toString() ?: "master"

    val logger = LogManager.getLogger(MOD_NAME)!!

    /*logger.info("Shutting down mod...")*/

    override fun onInitialize() {
        runCatching {
            logger.info("Launching $MOD_NAME version $MOD_VERSION [$MOD_BRANCH - $MOD_COMMIT] by $MOD_AUTHOR")
        }.onSuccess {
            logger.info("Successfully loaded mod!")
        }.onFailure {
            logger.error("Unable to load mod.", it)
            exitProcess(1)
        }
    }
}