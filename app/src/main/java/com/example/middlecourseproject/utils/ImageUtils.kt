package com.example.middlecourseproject.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import java.io.ByteArrayOutputStream

// Extension function on Context to convert a Uri into a Base64 string.
fun Context.convertUriToBase64(uri: Uri): String? {
    return try {
        val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
        Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}