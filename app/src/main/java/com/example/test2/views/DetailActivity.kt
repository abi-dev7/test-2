package com.example.test2.views

import android.os.Bundle
import com.example.test2.databinding.ActivityDetailBinding
import com.example.test2.utils.BarcodeConverter
import com.example.test2.utils.Decoder

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
            val tokenDecoded = Decoder.decode(token)
            binding?.barcode?.setImageBitmap(BarcodeConverter.getBarcode(tokenDecoded.header))
            binding?.txtTokenValue?.text = tokenDecoded.header
        }

        binding?.toolbar?.setNavigationOnClickListener{
            onBackPressed()
        }
    }
}