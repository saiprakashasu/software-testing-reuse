package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCourse {
    Course course;

    @BeforeEach
    void start() {
        course = new Course("SER515", 1);
    }

    @Test
    void testToString() {
        assertEquals(course.toString(), "SER515");
    }

    @Test
    void testAddAssignment() {
        Assignment assignment = new Assignment();
        course.addAssignment(assignment);
        assertTrue(course.assignmentList.contains(assignment));
    }


}
