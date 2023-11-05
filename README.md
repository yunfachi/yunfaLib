# yunfaLib
A library for Minecraft using the Fabric API that adds config, math, events, modules, and more.

## Setup

##### build.gradle
```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    modImplementation "com.github.yunfachi:yunfaLib:${project.yunfalib_version}"
}
```
##### gradle.properties
```properties
yunfalib_version=0.1.0
```

## Features

### Config
<details>
<summary>Example Java: The values are stored in the <b>inner class</b></summary>

```java
import moe.yunfachi.yunfalib.config.Config;
import java.io.File;

public class Example {
    private static class ConfigKeys {
        String truth = "this value is immediately saved to a file";
    }
    
    public Example() {
        final Config<ConfigKeys> config = new Config<>(
                new File("./modid/config.yml"), 
                new ConfigKeys()
        );
        
        config.get().truth = "this value will be written after config.save()";
        config.save();
    }
}
```
</details>
<details>
<summary>Example Java: The values are stored in the <b>nested class</b></summary>

```java
import moe.yunfachi.yunfalib.config.Config;
import java.io.File;

public class Example {
    public Example() {
        final Config<ConfigKeys> config = new Config<>(
                new File("./modid/config.yml"), 
                new ConfigKeys()
        );
        
        config.get().truth = "this value will be written after config.save()";
        config.save();
    }
}

class ConfigKeys {
    String truth = "this value is immediately saved to a file";
}
```
</details>
<br>
<details>
<summary>Example Kotlin: The values are stored in the <b>inner class</b></summary>

```kotlin
import moe.yunfachi.yunfalib.config.Config
import java.io.File

class Example {
    init {
        class ConfigKeys {
            var truth = "this value is immediately saved to a file"
        }

        val config = Config(
            File("./modid/config.yml"),
            ConfigKeys()
        )
        
        config.get().truth = "this value will be written after config.save()"
        config.save()
    }
}
```
</details>
<details>
<summary>Example Kotlin: The values are stored in an <b>anonymous object</b></summary>

```kotlin
import moe.yunfachi.yunfalib.config.Config
import java.io.File

class Example {
    init {
        val config = Config(
            File("./modid/config.yml"),
            object {
                var truth: String = "this value is immediately saved to a file"
            }
        )

        config.get().truth = "this value will be written after config.save()"
        config.save()
    }
}
```
</details>

## Thanks

| Project                                            | Author                                      | Description                        |
|----------------------------------------------------|---------------------------------------------|------------------------------------|
| [Annotaml](https://github.com/WiIIiam278/Annotaml) | [WiIIiam278](https://github.com/WiIIiam278) | library for generating YAML files  |

## Stats

![Alt](https://repobeats.axiom.co/api/embed/321da4fd0a3bf68fb4f40ef705be5c7da467e646.svg "Repobeats analytics image")
