package moe.yunfachi.testmod

import moe.yunfachi.yunfalib.config.Config
import net.fabricmc.api.ModInitializer
import java.io.File

object TestMod : ModInitializer {
    override fun onInitialize() {
        TestConfig()

        val config = Config(
            File("./testmod/kotlin.yml"),
            object {
                var truth: String = "this value is immediately saved to a file"
            }
        )

        config.get().truth = "this value will be written after config.save()"

        config.save()
    }
}