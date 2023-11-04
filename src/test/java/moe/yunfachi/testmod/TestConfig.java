package moe.yunfachi.testmod;

import moe.yunfachi.yunfalib.config.Config;

import java.io.File;

public class TestConfig {
    private static class ConfigKeys {
        String truth = "this value is immediately saved to a file";
    }
    public TestConfig() {

        Config<ConfigKeys> config = new Config<>(
                new File("./testmod/java.yml"),
                new ConfigKeys()
        );
        config.get().truth = "this value will be written after config.save()";
        config.save();
    }
}