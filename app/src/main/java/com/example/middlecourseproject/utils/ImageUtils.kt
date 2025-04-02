package com.example.middlecourseproject.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import java.io.ByteArrayOutputStream

fun Context.convertUriToBase64(uri: Uri): String? {
    return try {
        val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
        bitmap.toBase64()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun Bitmap.toBase64(quality: Int = 90): String {
    return try {
        val outputStream = ByteArrayOutputStream()
        compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
        Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}