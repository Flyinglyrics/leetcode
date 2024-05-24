import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import solutions.Solution2225;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Resolve {
    @ParameterizedTest
    @MethodSource
    public void resolve(int[][] input, List<List<Integer>>[][]expected) {
        assertEquals(expected, Solution2225.findWinners(input));
    }
    static List<Arguments> resolve() {
        return Arrays.asList(
                Arguments.of(123,false),
                Arguments.of([[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]],false),
                Arguments.of(120,false),
                Arguments.of(12321,true),
                Arguments.of(3212,false)
        );
    }
}