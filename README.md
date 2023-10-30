# yunfaLib

## Features

### Config
<details>
<summary>Example Java: The values are stored in the class</summary>

```kotlin
class ConfigTest {
    String truth = "this value is immediately saved to a file"
};

final Config config = new Config(
    "config",
    new File("./modid/config.yml"),
    new ConfigTest()
);

config.get().truth = "this value will be written after config.save()";

config.save();
```
</details>
<details>
<summary>Example Java: The values are stored in an anonymous object</summary>

```kotlin
final Config config = new Config(
    "config",
    new File("./modid/config.yml"),
    new Object() {
        String truth = "this value is immediately saved to a file"
    }
);

config.get().truth = "this value will be written after config.save()";

config.save();
```
</details>

<details>
<summary>Example Kotlin: The values are stored in the class</summary>

```kotlin
class ConfigTest {
    var truth: String = "this value is immediately saved to a file"
}

val config = Config(
    "config",
    File("./modid/config.yml"),
    ConfigTest()
)

config.get().truth = "this value will be written after config.save()"

config.save()
```
</details>
<details>
<summary>Example Kotlin: The values are stored in an anonymous object</summary>

```kotlin
val config = Config(
    "config",
    File("./modid/config.yml"),
    object {
        var truth: String = "this value is immediately saved to a file"
    }
)

config.get().truth = "this value will be written after config.save()"

config.save()
```
</details>

## Thanks

| Project                                            | Author                                      | Description                        |
|----------------------------------------------------|---------------------------------------------|------------------------------------|
| [Annotaml](https://github.com/WiIIiam278/Annotaml) | [WiIIiam278](https://github.com/WiIIiam278) | library for generating YAML files  |

## Stats

![Alt](https://repobeats.axiom.co/api/embed/321da4fd0a3bf68fb4f40ef705be5c7da467e646.svg "Repobeats analytics image")
