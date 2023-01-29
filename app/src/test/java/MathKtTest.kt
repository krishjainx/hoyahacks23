import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Assertions.*


import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

internal class MathKtTest {

    @Test
    fun domathtest() {

        // age:Int, retirementAge: Double, salary:Double, contributionRate:Double, contribution:Double, increase:Double, retirementSavings:Double): MutableList<RetirementStateModel> {
        val result = domath(18, 65.00, 10.00, 15.00, 20.00, 2000.00, 90000.00)

        assertEquals(expectedValue, actualValue)



    }
}