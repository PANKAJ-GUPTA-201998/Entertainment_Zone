package com.example.fun_zone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_joke.*


class Joke : AppCompatActivity() {
    var currentImageUrl:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        loadMeme()
        button2.setOnClickListener { loadMeme() }
        button.setOnClickListener { sharee() }
    }

    private fun sharee() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"hey check this cool stuff $currentImageUrl")
        val chooser =Intent.createChooser(intent,"share this...by")
        startActivity(chooser)
    }

    private fun loadMeme() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                currentImageUrl=response.getString("url")
                Glide.with(this).load(currentImageUrl).into(memeView)
            },
            {
                Toast.makeText(this, "not run", Toast.LENGTH_SHORT).show()
            })
        queue.add(jsonObjectRequest)
    }
}