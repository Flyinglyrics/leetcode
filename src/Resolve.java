import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import solutions.Solution3040;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Resolve {
    @ParameterizedTest
    @MethodSource
    public void resolve(int[] input,int expected) {
        assertEquals(expected,Solution3040.maxOperations(input));
    }
    static List<Arguments> resolve() {
        return Arrays.asList(
                Arguments.of(new int[]{3, 2, 1, 2, 3, 4}, 3),
                Arguments.of(new int[]{3,2,6,1,4}, 2),
                Arguments.of(new int[]{1,1,2,3,2,2,1,3,3}, 4)
        );
    }
    // Solution 10 arguments.
//    static List<Arguments> resolve() {
//        return Arrays.asList(
//                Arguments.of("aa","a",false),
//                Arguments.of("aa","a*",true),
//                Arguments.of("ab",".*",true),
//                Arguments.of("aab","c*a*b",true),
//                Arguments.of("mississippi","mis*is*ip*.",true),
//                Arguments.of("ab",".*c",false),
//                Arguments.of("aaa","a*a",true),
//                Arguments.of("aaa","aaaa",false)
//        );
//    }
}