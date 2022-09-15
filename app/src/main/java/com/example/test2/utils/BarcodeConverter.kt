package com.example.test2.utils

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder

class BarcodeConverter {
    companion object{

        fun getBarcode(text: String) : Bitmap{
            val multiFormatWriter =  MultiFormatWriter();
            var bitmap: Bitmap? = null;
            try {
                val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.CODE_39,600,400);
                val barcodeEncoder = BarcodeEncoder();
                bitmap = barcodeEncoder.createBitmap(bitMatrix);
            } catch (e: WriterException) {
                throw Exception(e.message)
            }
            return bitmap
        }
    }
}