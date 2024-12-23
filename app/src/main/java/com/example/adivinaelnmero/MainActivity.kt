package com.example.adivinaelnmero

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adivinaelnmero.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainBinding.buttonStart.setOnClickListener {
val intent = Intent(this@MainActivity, GameActivity::class.java)
            if(!mainBinding.radioButtonOne.isChecked && !mainBinding.radioButtonTwo.isChecked && !mainBinding.radioButtonThree.isChecked){
Snackbar.make(mainBinding.main,"Por favor escoge el número de dígitos del número a adivinar",Snackbar.LENGTH_SHORT).show()
            }else{
                if(mainBinding.radioButtonOne.isChecked){
                    intent.putExtra("number","one")
                }else if(mainBinding.radioButtonTwo.isChecked){
                    intent.putExtra("number","two")
                }else if(mainBinding.radioButtonThree.isChecked){
                    intent.putExtra("number","three")

                }

                startActivity(intent)
            }




        }

    }
}