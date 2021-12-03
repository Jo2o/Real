package java.packt.Chapter09.P178_TestMethodsThatUsesLambdas.test;

import org.junit.jupiter.api.Test;

import static java.packt.Chapter09.P178_TestMethodsThatUsesLambdas.src.modern.challenge.StringOperations.extractCharacter;
import static java.packt.Chapter09.P178_TestMethodsThatUsesLambdas.src.modern.challenge.StringOperations.firstAndLastChar;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LambdasTest {

    @Test
    public void testFirstAndLastChar() throws Exception {

        String text = "Lambda";
        String result = firstAndLastChar.apply(text);

        assertEquals("La", result);
    }

    @Test
    public void testRndStringFromStrings() throws Exception {

        String str1 = "Some";
        String str2 = "random";
        String str3 = "text";
        
        String result1 = extractCharacter(str1);
        String result2 = extractCharacter(str2);
        String result3 = extractCharacter(str3);

        assertEquals(result1.length(), 1);
        assertEquals(result2.length(), 1);
        assertEquals(result3.length(), 1);
        /*
        assertThat(str1, containsString(result1));
        assertThat(str2, containsString(result2));
        assertThat(str3, containsString(result3));
        */
    }
}
