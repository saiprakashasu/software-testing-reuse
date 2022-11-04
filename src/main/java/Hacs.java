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

public class Hacs {

    static hacs.Facade theFacade = new hacs.Facade();

    public Hacs() {
    }

    public static void main(String[] args) {
        hacs.UserInfoItem userinfoitem = new hacs.UserInfoItem();
        theFacade.createCourseList();
        while (true) {
            boolean bExit = false;
            bExit = hacs.Facade.login(userinfoitem);
            if (bExit)
                break;
            theFacade.createUser(userinfoitem);
            theFacade.attachCourseToUser();
            if (userinfoitem.userType == hacs.UserInfoItem.USER_TYPE.Student)
                theFacade.remind();
            boolean bLogout = false;
            while (!bLogout) {
                bLogout = theFacade.selectCourse();
                if (bLogout)
                    break;
                bLogout = theFacade.courseOperation();
            }
        }
    }
}