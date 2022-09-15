package com.example.test2

import android.content.Intent
import android.os.Bundle
import com.auth0.android.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import com.example.test2.databinding.ActivityMainBinding
import com.example.test2.models.apiresponses.PreferencesManager
import com.example.test2.services.CallManager
import com.example.test2.utils.Decoder
import com.example.test2.views.BaseActivity
import com.example.test2.views.DetailActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponents()
    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    fun initComponents(){
        binding!!.editTextUsername.setText("admin@macropay.mx")
        binding!!.editTextPassword.setText("Admin1");

        binding?.btnDoLogin?.setOnClickListener {
            val username = binding!!.editTextUsername.text.toString()
            val password = binding!!.editTextPassword.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val response = CallManager.getApiServiceManager()?.login(getLoginBodyRequest(username,password))
                val result = response?.body()
                if (result != null){

                    saveInPreferences(result.token)

                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    intent.putExtra("token", result.token)
                    startActivity(intent)
                }else{
                    //Show Error Message
                }
            }
        }
    }

    private fun getLoginBodyRequest(username: String, password: String):MultipartBody{
        return MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("email", username)
            .addFormDataPart("password", password)
            .build()
    }

    private fun saveInPreferences(token: String){
        val data = Decoder.decode(token)
        val header = data.header.toString()
        val payload = data.payload.toString()
        val signature = data.signature.toString()

        PreferencesManager(baseContext).header = header;
        PreferencesManager(baseContext).payload = payload;
        PreferencesManager(baseContext).signature = signature;
    }
}