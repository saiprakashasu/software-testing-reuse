package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Java 8
 */

public class UserInfoItem {

	String strUserName;
	USER_TYPE userType; // 0 : Student, 1: Instructor
	public enum USER_TYPE {
		Student, Instructor
	}
}
