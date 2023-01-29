package com.ezyretirement.app.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezyretirement.app.databinding.ActivityMainBinding
import com.ezyretirement.app.ext.commitFragment
import com.ezyretirement.app.views.stimulation.StimulationFragment
import com.ezyretirement.app.views.userInformation.UserInformationFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        commitFragment(UserInformationFragment())

    }
}