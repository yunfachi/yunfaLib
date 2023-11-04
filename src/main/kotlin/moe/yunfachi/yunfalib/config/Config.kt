package moe.yunfachi.yunfalib.config

import net.william278.annotaml.Annotaml
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Config<T : Any>(file: File, config: T) {
    private val file: File
    private var config: T

    private var annotaml: Annotaml<Any>

    init {
        this.file = file
        this.annotaml = Annotaml.create(file, config)
        this.config = annotaml.get() as T
    }

    fun get(): T {
        return this.config
    }

    /**
     * Read config from file without saving current config
     *
     * @param file File to be read. By default, the file specified during initialization.
     * @throws FileNotFoundException If the file does not exist
     * @throws IOException If the file cannot be read
     */
    @Throws(IOException::class, FileNotFoundException::class)
    fun read(file: File=this.file) {
        if (!file.exists())
            throw FileNotFoundException("File \"${file.path}\" (${file.canonicalPath}) does not exist")
        if (!file.canRead())
            throw IOException("File \"${file.path}\" (${file.canonicalPath}) cannot be read")
        this.annotaml = Annotaml.create(file, this.config)
        this.config = this.annotaml.get() as T
    }

    /**
     * Save the current config to a file
     *
     * @param file File to be written or overwritten. By default, the file specified during initialization.
     * @throws IOException If there is a directory with the file name
     * @throws IOException If the file cannot be written
     */
    fun save(file: File=this.file) {
        if (file.isDirectory)
            throw IOException("Unable to create \"${file.path}\" (${file.canonicalPath}) file due to existing directory")
        if (!file.canWrite())
            throw IOException("File \"${file.path}\" (${file.canonicalPath}) cannot be written")
        this.annotaml = Annotaml.create(this.config)
        this.annotaml.save(file)
    }
}