package hacs;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * update to Java 8
 */

/*
 * this class will iterate the course list attatched to on student and in turn
 * iterate the assignments of a course. after Function Visit(CourseList) it will
 * point to the location before the fist class, hasNext will retrun weather
 * there is next item. the next() will return the next Item Assignment;
 */

public class ReminderVisitor extends hacs.NodeVisitor {

	hacs.Reminder m_Reminder;

	public ReminderVisitor() {
	}

	public ReminderVisitor(hacs.Reminder reminder) {
		m_Reminder = reminder;
	}

	public void visitFacade(hacs.Facade facade) {
		hacs.CourseIterator courseList = new hacs.CourseIterator(facade.theCourseList);
		while (courseList.hasNext()) {
			hacs.Course course = (hacs.Course) courseList.next();
			course.accept(this);
		}
	}

	public void visitCourse(hacs.Course course) {
		Iterator<hacs.Assignment> assignmentList = course.assignmentList.listIterator();
		while (assignmentList.hasNext()) {
			hacs.Assignment assignment = (hacs.Assignment) assignmentList.next();
			assignment.accept(this);
		}
	}

	public void visitAssignment(hacs.Assignment assignment) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(assignment.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{
			m_Reminder.listUpcoming.add("today is " + today.toString() + " " + assignment.assignmentName
					+ " Due Date is " + assignment.getDueDateString());
		}
		if (nDueDate < ntoday) {
			// put to the
			m_Reminder.listOverdue.add(assignment.assignmentName + " Due Date is " + assignment.getDueDateString());
		}

	}

}