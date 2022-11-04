package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStudent {

    @Test
    void testCreateCourseMenu() {
        hacs.Course course = new hacs.Course("SER515", 1);
        hacs.Student student = new hacs.Student();
        assertTrue(student.createCourseMenu(course, 1) instanceof hacs.LowLevelCourseMenu);
    }

}
