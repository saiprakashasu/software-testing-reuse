package hacs;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<hacs.Course> {

	public ClassCourseList() {
	}

	// initialize the list by reading from the file.
	void initializeFromFile(String courseListFile) {
		Scanner scanner;
		try {
			String strCourseName = null;
			File file = new File(courseListFile);
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				strCourseName = scanner.nextLine();
				hacs.Course theCourse;
				theCourse = new hacs.Course(strCourseName, 0);
				add(theCourse);
			}
			scanner.close();
		} catch (Exception ee) {

		}
	}

	hacs.Course findCourseByCourseName(String CourseName) {
		int nCourseCount = size();
		for (int i = 0; i < nCourseCount; i++) {
			hacs.Course theCourse;
			theCourse = (hacs.Course) get(i);
			if (theCourse.courseName.compareTo(CourseName) == 0)
				return theCourse;
		}
		return null;
	}

}