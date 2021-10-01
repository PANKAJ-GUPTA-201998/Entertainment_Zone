package com.example.fun_zone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jokeShare.setOnClickListener { sendJoke()
        }
        memeShare.setOnClickListener { sendMeme() }
        gifShare.setOnClickListener { sendGif() }
    }

    private fun sendGif() {
        val intent= Intent(this,GifShare::class.java)
        startActivity(intent)
    }

    private fun sendMeme() {
        val intent = Intent(this,Joke::class.java)
        startActivity(intent)
    }

    private fun sendJoke() {
        val intent = Intent(this,Joke::class.java)
        startActivity(intent)
    }
}
