package com.example.multipaneview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val option: String? = intent.getStringExtra("1")


        when (option) {
            "frontend" -> {
                supportFragmentManager.beginTransaction().add(R.id.settingsContainer, Frontend())
                    .commit()
            }

            "backend" -> {
                supportFragmentManager.beginTransaction().add(R.id.settingsContainer, Backend())
                    .commit()
            }

            "database" -> {
                supportFragmentManager.beginTransaction().add(R.id.settingsContainer, Database())
                    .commit()
            }
        }


    }
}