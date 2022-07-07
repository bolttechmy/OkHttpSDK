package com.example.okhttptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

import com.overlook.android.fingkit.FingScanner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this@MainActivity, "New func added sss", Toast.LENGTH_LONG).show()
        val scanner: FingScanner = FingScanner.getInstance()
        findViewById<Button>(R.id.btn_api_resp).setOnClickListener {
            Toast.makeText(this@MainActivity, "New func added eee", Toast.LENGTH_LONG).show()
            CoroutineScope(Dispatchers.IO).launch {
                val a = getResponse("https://reqres.in/api/users/2")
                Log.e("TAG", a);
            }
        }
    }
}

fun getResponse(url: String): String {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url(url)
        .build();

    val response: Response = client.newCall(request).execute()
    return response.body?.string() ?: ""
}