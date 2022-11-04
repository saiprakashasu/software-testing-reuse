package hacs;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class TestAssignment {
    Assignment assignment;

    @BeforeEach
    void start() {
        assignment = new Assignment();
    }

    @Test
    void testGetSuggestedSolution() {
        Solution solution = new Solution();
        assignment.suggestedSolution = solution;
        assertEquals(assignment.getSuggestedSolution(), solution);
    }

    @Test
    void testGetSolutionIterator() {
        assertTrue(assignment.getSolutionIterator() instanceof SolutionIterator);
    }

    @Test
    void testIsOverDue() {
        Date dueDate = new GregorianCalendar(2022, Calendar.MARCH, 20).getTime();
        assignment.setDueDate(dueDate);
        assertTrue(assignment.isOverDue());
        dueDate = new GregorianCalendar(2023, Calendar.NOVEMBER, 20).getTime();
        assignment.setDueDate(dueDate);
        assertFalse(assignment.isOverDue());
    }

    @Test
    void testGetDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        assignment.dueDate = new Date();
        assertEquals(assignment.getDueDateString(), dateFormat.format(new Date()));
    }

    @Test
    void testSetDueDate() {
        Date today = new Date();
        assignment.setDueDate(today);
        assertEquals(today, assignment.dueDate);
    }

    @Test
    void testGetSolution() {
        Solution solution = new Solution();
        solution.theAuthor = "sai";
        assignment.addSolution(solution);
        assertEquals(solution, assignment.getSolution("sai"));
    }

    @Test
    void testSetAssignmentSpec() {
        assignment.setAssignmentSpec("STRING");
        assertEquals("STRING", assignment.assignmentSpec);
    }
}
