package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCourseIterator {
    CourseIterator itr;
    ClassCourseList courseList;

    @BeforeEach
    void start() {
        courseList = new ClassCourseList();
        courseList.initializeFromFile("CourseInfo.txt");
        itr = new CourseIterator(courseList);
    }

    @Test
    void testNextString() {
        assertEquals(itr.next("SER502").courseName, "SER502");
        assertNull(itr.next("CS"));
    }

    @Test
    void testNext() {
        assertEquals(itr.next().courseName, "SER515");
        assertEquals(itr.next().courseName, "SER502");
    }


    @Test
    void testNextNull() {
        courseList = new ClassCourseList();
        itr = new CourseIterator(courseList);
        assertNull(itr.next());

    }

    @Test
    void testRemove() {
        int length = itr.theCourseList.size();
        itr.remove();
        assertEquals(itr.theCourseList.size(), length - 1);
    }

    @Test
    void testHasNext() {
        assertTrue(itr.hasNext());
        courseList = new ClassCourseList();
        itr = new CourseIterator(courseList);
        assertFalse(itr.hasNext());
    }

}
