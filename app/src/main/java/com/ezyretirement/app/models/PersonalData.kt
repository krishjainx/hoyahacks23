package com.ezyretirement.app.models

data class PersonalData(
    var name: String = "",
    var userProfileImageUrl: String = "",
    var occupation: String = "",
    var dob: Long = 0,
    var age: Int = 0,
    var currentSalary: Double = 0.0,
    var yearlyContribution: Double = 0.0,
    var retirementAge: Int = 0,
    var desiredActiveRetirementSalary: Double = 0.0,
    var retirementSavings: Double = 0.0,
    var retirementStages: MutableList<RetirementStateModel> = mutableListOf(),
    var salaryIncrease: Double = 0.0,
    var currentSavings: Double = 0.0,
    var savingsInterest: Double = 0.0,
    var totalRetirementSaving: Double = 0.0
)
