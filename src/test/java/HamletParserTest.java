import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        String expected = "My name is Leon";
        String input = "My name is Hamlet";
        //When
        String actual = hamletParser.hamletToLeon(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String expected = "My name is Tariq";
        String input = "My name is Horatio";
        //When
        String actual = hamletParser.horatioToTariq(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //Given
        String input = "My name is Horatio";
        //Then
        Assert.assertTrue(hamletParser.findHoratio(input));

    }

    @Test
    public void testFindHamlet() {
        //Given
        String input = "My name is Hamlet";
        //Then
        Assert.assertTrue(hamletParser.findHamlet(input));
    }

    @Test
    public void hamletParsertest(){

        String hamToLeon = hamletParser.hamletToLeon(hamletText);
        String horToTariq = hamletParser.horatioToTariq(hamToLeon);
        String bigHam = hamletParser.bigHamChanger(horToTariq);
        String bigTor = hamletParser.bigHorChanger(bigHam);
        System.out.println(bigTor);
    }
}