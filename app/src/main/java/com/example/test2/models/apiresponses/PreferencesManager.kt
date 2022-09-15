package com.example.test2.models.apiresponses

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    companion object {
        const val Username = "Username"
        const val Header = "Header"
        const val Payload = "Payload"
        const val Signature = "Signature"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences("preferences", Context.MODE_PRIVATE)


    var header: String
        get() = preferences.getString(Header, "") ?: ""
        set(value) = preferences.edit().putString(Header, value).apply()

    var payload: String
        get() = preferences.getString(Payload, "") ?: ""
        set(value) = preferences.edit().putString(Payload, value).apply()

    var signature: String
        get() = preferences.getString(Signature, "") ?: ""
        set(value) = preferences.edit().putString(Signature, value).apply()

}