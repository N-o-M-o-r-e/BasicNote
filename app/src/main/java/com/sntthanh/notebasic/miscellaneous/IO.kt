package com.sntthanh.notebasic.miscellaneous

import android.app.Application
import android.os.Build
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.file.Files

object IO {
    fun copyStreamToFile(input: InputStream, destination: File) {
        val output = FileOutputStream(destination)
        input.copyTo(output)
        input.close()
        output.close()
    }
}