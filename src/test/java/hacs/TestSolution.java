package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSolution {
    Solution solution;

    @BeforeEach
    void start() {
        solution = new Solution();
        solution.theAuthor = "Sai";
        solution.solutionFileName = "solution.txt";
        solution.theGrade = 1;
        solution.reported = true;
    }

    @Test
    void testGetGradeString() {
        assertEquals(solution.getGradeString(), "1");
        solution.reported = false;
        assertEquals(solution.getGradeString(), "-1");
    }

    @Test
    void testToString() {
        assertEquals(solution.toString(), "Sai  solution.txt Grade=1  reported");
    }

    @Test
    void getGradeString() {
        assertEquals(solution.getGradeString(), Integer.toString(solution.theGrade));
    }

    @Test
    void testGetGradeInt() {
        assertEquals(solution.getGradeInt(), solution.theGrade);
    }

    @Test
    void isReported() {
        assertEquals(solution.isReported(), solution.reported);
    }


}
