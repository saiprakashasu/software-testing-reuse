package hacs;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

public class Student extends hacs.Person {

	public Student() {
		type = 0; // type=0: student
	}

	public hacs.CourseMenu createCourseMenu(hacs.Course theCourse, int theLevel) {

		if (theLevel == 0) // 0: Highlevel defined in CourseSelectDlg.
		{
			theCourseMenu = new hacs.HighLevelCourseMenu();
		} else // 1: LowLevel
		{
			theCourseMenu = new hacs.LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	@Override
	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}