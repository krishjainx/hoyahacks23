package com.ezyretirement.app.views.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ezyretirement.app.databinding.FragmentProfileBinding
import com.ezyretirement.app.ext.replaceFragmentWith
import com.ezyretirement.app.models.PersonalData
import com.ezyretirement.app.views.personalData.PersonalDataFragment
import com.google.android.material.transition.MaterialFadeThrough

class ProfileFragment(private val personData:PersonalData) : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.personalData.setOnClickListener() {
            replaceFragmentWith(PersonalDataFragment(personData))
        }

        binding.toolbar.backBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }


    }
}