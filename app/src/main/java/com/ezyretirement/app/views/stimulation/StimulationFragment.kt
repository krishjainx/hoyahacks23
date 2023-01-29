package com.ezyretirement.app.views.stimulation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezyretirement.app.adapters.RetirementStageListAdapter
import com.ezyretirement.app.databinding.StimulationFragmentBinding
import com.ezyretirement.app.ext.replaceFragmentWith
import com.ezyretirement.app.ext.toUSD
import com.ezyretirement.app.models.PersonalData
import com.ezyretirement.app.viewModels.UserDataViewModel
import com.ezyretirement.app.views.profile.ProfileFragment
import com.google.android.material.transition.MaterialFadeThrough
import domath

class StimulationFragment(private val personData: PersonalData) : Fragment() {

    private val viewModel by viewModels<UserDataViewModel>()
    private lateinit var binding: StimulationFragmentBinding
    private var retirementAge = personData.retirementAge


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StimulationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setRetirementText()


            binding.userName.text = personData.name
            binding.currentRetirementNest.text = personData.totalRetirementSaving.toUSD()

            binding.yearlyContribution.text = "${personData.yearlyContribution} %"



        binding.retirementStageList.apply {
            adapter = RetirementStageListAdapter(personData.retirementStages,requireContext())
        }



        binding.userProfile.setOnClickListener {
            replaceFragmentWith(ProfileFragment(personData))
        }

        binding.plus.setOnClickListener {
            increaseRetirementYear()
        }


        binding.minus.setOnClickListener {
            decreaseRetirementYear()
        }

    }


    private fun increaseRetirementYear() {
        retirementAge++
        computeRetirementPolicy(retirementAge)
        setRetirementText()
    }


    private fun decreaseRetirementYear() {
        retirementAge--
        computeRetirementPolicy(retirementAge)
        setRetirementText()
    }


    private fun setRetirementText() {
        "$retirementAge Years old".also { binding.retirementAge.text = it }
    }


    private fun computeRetirementPolicy(age:Int) {



        var retirementAge = personData.retirementAge
        var salary = personData.currentSalary
        val contributionRate = personData.yearlyContribution/100
        var contribution = salary * contributionRate
        val increase = personData.salaryIncrease/100
        var retirementSavings = salary * contributionRate
        var totalRetirement = 0.0


        val data = domath(retirementAge, salary, contributionRate, contribution, increase, retirementSavings, totalRetirement)




        binding.retirementSavings.text = totalRetirement.toUSD()
        personData.totalRetirementSaving = totalRetirement


        binding.retirementStageList.apply {
            adapter = RetirementStageListAdapter(data,requireContext())
        }

    }

}