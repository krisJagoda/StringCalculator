package uk.co.krystianjagoda.stringcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

public class CalculatorTest {
    private Calculator calculator;
    private static final double DELTA = 0.1;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

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

    @Test
    public void forAStringOf1plus1ReturnDouble2() throws Exception {
        String equation = "1+1";
        double expectedResult = 2.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAStringOf1plus1Plus1ReturnDouble3() throws Exception {
        String equation = "1+1+1";
        double expectedResult = 3.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAStringOf2Times2ReturnDouble4() throws Exception {
        String equation = "2*2";
        double expectedResult = 4.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAStringOf2Times2Times2ReturnDouble8() throws Exception {
        String equation = "2*2*2";
        double expectedResult = 8;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAStringOF2minus1ReturnDouble1() throws Exception {
        String equation = "2-1";
        double expectedResult = 1.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAString3minus1minus1ReturnDouble1() throws Exception {
        String equation = "3-1-1";
        double expectedResult = 1.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }

    @Test
    public void forAString4dividedBy2ReturnDouble2() throws Exception {
        String equation = "4/2";
        double expected = 2.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expected, within(DELTA));
    }

    @Test
    public void forAString8DividedBy2DividedBy2ReturnDouble2() throws Exception {
        String equation = "8/2/2";
        double expected = 2.0;

        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expected, within(DELTA));
    }

    @Test
    public void forADivisionBy0ThrowAnIllegalArgumentException() throws Exception {
        String equation = "8/2/0";

        assertThatThrownBy(() -> calculator.calculate(equation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You cannot divide by 0");
    }


    @Test
    public void forAStringOf3plus4Times5Minus6ReturnDouble17() {
        String equation = "3+4*5-6";
        double expectedResult = 17.0;
        double actualResult = calculator.calculate(equation);

        assertThat(actualResult).isCloseTo(expectedResult, within(DELTA));
    }
}