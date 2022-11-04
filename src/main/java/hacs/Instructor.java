package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class Instructor extends hacs.Person {

	public Instructor() {
		type = 1;
	}

	public hacs.CourseMenu createCourseMenu(hacs.Course theCourse, int theLevel) {
		if (theLevel == 0) // 0: Highlevel
		{
			theCourseMenu = new hacs.HighLevelCourseMenu();
		} else // 1: LowLevel
		{
			theCourseMenu = new hacs.LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}