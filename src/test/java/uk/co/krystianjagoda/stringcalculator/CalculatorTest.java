package uk.co.krystianjagoda.stringcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class CalculatorTest {
    private Calculator calculator;
    private static final double DELTA = 0.1;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    /*
    @Test
    public void featureTest() {
        String equation = "3+4*5-6";
        double expectedResult = 17;
        double result = calculator.calculate(equation);

        assertThat(result).isEqualTo(expectedResult);
    }
    */

    @Test
    public void forAStringOf1ReturnDouble1() throws Exception {
        String equation = "1";
        double expectedResult = 1.0;
        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAStringOf2ReturnDouble2() throws Exception {
        String equation = "2";
        double expectedResult = 2.0;
        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }
}