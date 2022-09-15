package com.example.test2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityDetailBinding
import com.example.test2.utils.BarcodeConverter

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponents()
    }

    override fun getViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    private fun initComponents(){
        setSupportActionBar(binding?.toolbar)

        val token = intent.getStringExtra("token")
        if (token != null){
            binding?.barcode?.setImageBitmap(BarcodeConverter.getBarcode(token))
            binding?.txtTokenValue.text = token.split("ZA>°!")
        }
    }
}