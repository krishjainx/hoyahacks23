package com.ezyretirement.app.views.loginSplash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezyretirement.app.databinding.ActivityLoginSplashBinding
import com.ezyretirement.app.views.MainActivity

class LoginSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.getStartedBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}