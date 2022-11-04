package hacs;

import java.io.File;
import java.util.Scanner;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Jave 8
 */

public class Facade {
	public int userType;
	hacs.ClassCourseList theCourseList;
	hacs.Person thePerson;
	private hacs.Course theSelectedCourse = null;
	private int nCourseLevel = 0;

	public Facade() {
	}

	static public boolean login(hacs.UserInfoItem userinfoItem) {
		hacs.Login login = new hacs.Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.getUserName();
		userinfoItem.userType = login.getUserType();
		return login.isExit();
	}

/////////////////////////
//functions for CourseMenu
	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	void addAssignment(hacs.Course theCourse) {
		hacs.AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new hacs.StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new hacs.InstructorAssignmentMenu();
		}
		hacs.Assignment theAssignment = new hacs.Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void viewAssignment(hacs.Assignment theAssignment) {
		hacs.AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new hacs.StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new hacs.InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

//functions for InstructorAssignmentMenu
	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	void gradeSolution(hacs.Solution theSolution) {
		hacs.SolutionMenu solutionMenu = new hacs.SolutionMenu();
		solutionMenu.showMenu(theSolution);
	}

	void reportSolutions(hacs.Assignment theAssignment) {
		hacs.Solution theSolution;
		hacs.SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (hacs.Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (hacs.Solution) theSolutionIterator.next();
		}
	}
////////////////////

	//functions for StudentAssignmentMenu
	void submitSolution(hacs.Assignment theAssignment, hacs.Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	//////////
	void remind() {
		hacs.Reminder theReminder = new hacs.Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(hacs.UserInfoItem userinfoitem) {
		if (userinfoitem.userType == hacs.UserInfoItem.USER_TYPE.Student) /// student
		{
			thePerson = new hacs.Student();
		} else /// instructor
		{
			thePerson = new hacs.Instructor();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		theCourseList = new hacs.ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		Scanner scanner;
		File file;
		try {
			file = new File("UserCourse.txt");
			scanner = new Scanner(file);
			String strUserName, strCourseName, user;
			while (scanner.hasNextLine()) // not the EOF
			{
				user = scanner.nextLine();
				strUserName = getUserName(user);
				strCourseName = getCourseName(user);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName mateches
				{
					theSelectedCourse = findCourseByCourseName(strCourseName);
					if (theSelectedCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.addCourse(theSelectedCourse);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String getUserName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(0, sep);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(sep + 1, aline.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelectedCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		hacs.CourseSelectDlg theDlg = new hacs.CourseSelectDlg();
		theSelectedCourse = theDlg.showDlg(thePerson.CourseList);
		thePerson.CurrentCourse = theSelectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private hacs.Course findCourseByCourseName(String strCourseName) {
		hacs.CourseIterator Iterator = new hacs.CourseIterator(theCourseList);
		return (hacs.Course) Iterator.next(strCourseName);
	}

}