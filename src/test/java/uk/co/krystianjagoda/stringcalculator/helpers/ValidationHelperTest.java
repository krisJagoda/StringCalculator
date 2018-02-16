package uk.co.krystianjagoda.stringcalculator.helpers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Before;
import org.junit.Test;

public class ValidationHelperTest {
    private ValidationHelper helper;

    @Before
    public void setUp() throws Exception {
        helper = new ValidationHelper();
    }

    @Test
    public void forAStringWithValueOf1ReturnTrue() throws Exception {

        assertThat(helper.validateInputFromUser("1")).isTrue();
    }

    @Test
    public void forAStringWithLettersReturnFalse() throws Exception {

        assertThat(helper.validateInputFromUser("abc")).isFalse();
    }

    @Test
    public void forAStringWithValues1plus1ReturnTrue() throws Exception {

        assertThat(helper.validateInputFromUser("1+1")).isTrue();
    }

    @Test
    public void forAStringContainingWhitespacesReturnTrue() throws Exception {

        assertThat(helper.validateInputFromUser(" 1+ 1 ")).isTrue();
    }


    @Test
    public void forAnEmptyStringReturnFalse() throws Exception {

        assertThat(helper.validateInputFromUser("")).isFalse();
    }

    @Test
    public void forANullStringThrowANullPointerException() throws Exception {

        assertThatThrownBy(() -> helper.validateInputFromUser(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void forAnEquationOf1plus2minus3dividedBy4Times5WithoutSpacesReturnTrue() throws Exception {
        String equation = "1+2-3/4*5";

        assertThat(helper.validateInputFromUser(equation)).isTrue();
    }

    @Test
    public void forAnEquationOf1plus2minus3dividedBy4Times5WithSpacesBetweenReturnTrue() throws Exception {
        String equation = "1+ 2-3/ 4* 5";

        assertThat(helper.validateInputFromUser(equation)).isTrue();
    }
    @Test
    public void forAnEquationOf1plus2minus3dividedBy4Times5WithWhitespacesInTheBeginningAndEndingOfTheEquationReturnTrue() throws Exception {
        String equation = " 1+2-3/4*5 ";

        assertThat(helper.validateInputFromUser(equation)).isTrue();
    }

    @Test
    public void forAnInputOfOtherCharactersOtherThanNumbersAndMathematicalSymbolsReturnFalse() throws Exception {
        String input = "1,5._";

        assertThat(helper.validateInputFromUser(input)).isFalse();
    }
}