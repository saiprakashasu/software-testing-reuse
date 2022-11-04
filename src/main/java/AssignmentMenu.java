package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog
{
  abstract void ShowMenu(Assignment assignment ,Person person);
  public AssignmentMenu()
  {
    setModal(true);
    setSize(575,330);
  }
}