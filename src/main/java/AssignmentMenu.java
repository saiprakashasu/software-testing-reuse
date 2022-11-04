package hacs;

import javax.swing.JDialog;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog {
  public AssignmentMenu() {
    setModal(true);
    setSize(575, 330);
  }

  abstract void showMenu(hacs.Assignment ass, hacs.Person per);
}