package com.example.adivinaelnmero

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adivinaelnmero.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {


    lateinit var gameBinding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameBinding = ActivityGameBinding.inflate(layoutInflater)
        val view = gameBinding.root

        enableEdgeToEdge()
        setContentView(view)
        gameBinding.toolbarGame.setNavigationOnClickListener {
            finish()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        when(intent.getStringExtra("number").toString()){
"one" -> Toast.makeText(applicationContext,"Un dígito",Toast.LENGTH_SHORT).show()
            "two" -> Toast.makeText(applicationContext,"Dos dígitos",Toast.LENGTH_SHORT).show()
            "three" -> Toast.makeText(applicationContext,"Tres dígitos",Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
        }

    }
}