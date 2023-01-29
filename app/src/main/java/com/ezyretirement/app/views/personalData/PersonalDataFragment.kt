package com.ezyretirement.app.views.personalData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezyretirement.app.R
import com.ezyretirement.app.databinding.PersonalDataFragmentBinding
import com.ezyretirement.app.ext.text
import com.ezyretirement.app.ext.toUSD
import com.ezyretirement.app.models.PersonalData
import com.google.android.material.transition.MaterialFadeThrough

class PersonalDataFragment(private val personData:PersonalData) : Fragment() {
    private val viewModel by viewModels<PersonalDataViewModel>()
    private lateinit var binding: PersonalDataFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PersonalDataFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title.text = getString(R.string.personal_data)
        binding.toolbar.title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        binding.toolbar.backBtn.setColorFilter(ContextCompat.getColor(requireContext(),R.color.white))


        binding.name.editText?.setText(personData.name)
        binding.occupation.editText?.setText(personData.occupation)
        binding.dob.editText?.setText(personData.age.toString())
        binding.currentSalary.editText?.setText(personData.currentSalary.toUSD())
        binding.salaryIncreaseRate.editText?.setText("${personData.salaryIncrease}%")
        binding.yearsToRetirement.editText?.setText(personData.retirementAge.toString())
        binding.yearlyContribution.editText?.setText("${personData.yearlyContribution}%")
        binding.savings.editText?.setText(personData.currentSavings.toUSD())
        binding.savingsInterest.editText?.setText("${personData.savingsInterest}%")
        binding.desiredActiveRetirementSalary.editText?.setText(personData.desiredActiveRetirementSalary.toUSD())


        binding.toolbar.backBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

}