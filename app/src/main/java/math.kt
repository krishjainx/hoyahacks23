import com.ezyretirement.app.models.RetirementStateModel


     fun domath(age:Int, retirementAge: Double, salary:Double, contributionRate:Double, contribution:Double, increase:Double, retirementSavings:Double): MutableList<RetirementStateModel> {

         val data = mutableListOf<RetirementStateModel>()

        var ageVar:Int = age
        var retirementAgeVar: Double = retirementAge
        var salaryVar: Double = salary
        var contributionRateVar: Double = contributionRate
        var contributionVar: Double = contribution
        var increaseVar: Double = increase
        var retirementSavingsVar: Double = retirementSavings

         // variable to store totalRetirement

         var totalRetirement: Double = 0.0;

         while (retirementAge > age) {
             retirementAgeVar--
             salaryVar += (salaryVar * increaseVar)
             retirementSavingsVar += (salaryVar * contributionRateVar)
             contributionVar = salaryVar * contributionRateVar

             totalRetirement+= retirementSavingsVar

             data.add(
                 RetirementStateModel(
                     salary = salaryVar,
                     retirementSavings = retirementSavingsVar,
                     year = retirementAge,
                     contributionAmount = contributionVar
                 )
             )


         }

         return data;

    }

