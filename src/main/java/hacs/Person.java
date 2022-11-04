package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	String UserName;
	hacs.ClassCourseList CourseList;
	hacs.CourseMenu theCourseMenu;
	hacs.Course CurrentCourse;
	hacs.Assignment CurrentAssignment;

	public Person() {
		CourseList = new hacs.ClassCourseList();
	}

	abstract public hacs.CourseMenu createCourseMenu(hacs.Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.showComboxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
		theCourseMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	// show the assignment list
	public boolean showMenu() {
		// create a iterator for the assignment list
//    Iterator theIter=new ListIterator(CurrentCourse.AssList );
		Iterator<hacs.Assignment> theIter = CurrentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = CurrentCourse;
		hacs.Assignment theAssignment;
		while (theIter.hasNext()) {
			theAssignment = (hacs.Assignment) theIter.next();
			theCourseMenu.assignmentCombox.addItem(theAssignment);
		}
		return false;
	}

	public hacs.ClassCourseList getCourseList() {
		return CourseList;
	}

	public void addCourse(hacs.Course theCourse) {
		CourseList.add(theCourse);
	}
}