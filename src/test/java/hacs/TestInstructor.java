package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestInstructor {

    @Test
    void testCreateCourseMenu() {
        Course course = new Course("SER515", 1);
        Instructor instructor = new Instructor();
        assertTrue(instructor.createCourseMenu(course, 1) instanceof LowLevelCourseMenu);
    }

}
