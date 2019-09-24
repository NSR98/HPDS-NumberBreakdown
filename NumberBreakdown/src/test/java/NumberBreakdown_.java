import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class NumberBreakdown_ {

    private int number;
    private int[][] breakdown;
    private ArrayList<int[]> solution;

    public NumberBreakdown_(int number, int[][] breakdown) {
        this.number = number;
        this.breakdown = breakdown;
        solution = new ArrayList<>();
    }

    @Parameterized.Parameters
    public static Object[][] cases () {
        return new Object[][] {
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {6, new int[][]{{6,0}}},
                {10, new int[][]{{1,1}}},
                {15, new int[][]{{1,1},{5,0}}},
                {200, new int[][]{{2,2}}},
                {508, new int[][]{{5,2},{8,0}}},
                {9678, new int[][]{{9,3},{6,2},{7,1},{8,0}}},
                {4001, new int[][]{{4,3},{1,0}}},
                {111234, new int[][]{{1,5},{1,4},{1,3},{2,2},{3,1},{4,0}}}
        };
    }

    @Test
    public void execute () {
        assertThat(breakOf(number)).isEqualTo(this.breakdown);
    }

    public int[][] breakOf(int number) {

        if (number >= 100000) solution.add(hundredsThousandsFrequency(number));

        if (number >= 10000) solution.add(tensThousandsFrequency(number));

        if (number >= 1000) solution.add(thousandsFrequency(number));

        if (number >= 100) solution.add(hundredsFrequency(number));

        if (number >= 10) solution.add(tensFrequency(number));

        solution.add(unitsFrequency(number));

        for (int i = 0; i < solution.size(); i ++) {
            if (solution.get(i)[0] == 0) solution.remove(i--);
        }

        return solution.toArray(new int[solution.size()][2]);
    }

    private int[] unitsFrequency(int number) {
        return new int[]{number % 10, 0};
    }

    private int[] tensFrequency(int number) {
        return new int[]{(number % 100) / 10, 1};
    }

    private int[] hundredsFrequency(int number) {
        return new int[]{(number % 1000) / 100, 2};
    }

    private int[] thousandsFrequency(int number) {
        return new int[]{(number % 10000) / 1000, 3};
    }

    private int[] tensThousandsFrequency(int number) {
        return new int[]{(number % 100000) / 10000, 4};
    }

    private int[] hundredsThousandsFrequency(int number) {
        return new int[]{(number % 1000000) / 100000, 5};
    }

}
