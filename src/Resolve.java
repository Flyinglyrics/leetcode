import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import solutions.Solution9;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Resolve {
    @ParameterizedTest
    @MethodSource
    public void resolve(int input,boolean expected) {
        assertEquals(expected, Solution9.isPalindrome(input));
    }
    static List<Arguments> resolve() {
        return Arrays.asList(
                Arguments.of(123,false),
                Arguments.of(-42,false),
                Arguments.of(120,false),
                Arguments.of(12321,true),
                Arguments.of(3212,false)
        );
    }
}