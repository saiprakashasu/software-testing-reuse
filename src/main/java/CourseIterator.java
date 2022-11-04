package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class CourseIterator implements Iterator<hacs.Course> {
  hacs.ClassCourseList theCourseList;
  int currentCourseNumber = -1;

  public CourseIterator() {
  }

  public CourseIterator(hacs.ClassCourseList courseList) {
    theCourseList = courseList;
  }

  public boolean hasNext() {
    if (currentCourseNumber >= theCourseList.size() - 1)
      return false;
    else
      return true;
  }

  public hacs.Course next() {
    if (hasNext() == true) {
      currentCourseNumber++;
      return theCourseList.get(currentCourseNumber);
    } else {
      return null;
    }
  }

  public void remove() {
    if (currentCourseNumber == -1)
      currentCourseNumber++;
    theCourseList.remove(currentCourseNumber);
  }

  // the next Course that fits the given CourseName
  public hacs.Course next(String courseName) {
    hacs.Course theCourse;
    theCourse = (hacs.Course) next();
    while (theCourse != null) {
      if (courseName.compareTo(theCourse.toString()) == 0) {
        return theCourse;
      }
      theCourse = (hacs.Course) next();
    }
    return null;
  }

}