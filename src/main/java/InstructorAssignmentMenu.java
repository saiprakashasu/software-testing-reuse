package hacs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class InstructorAssignmentMenu extends hacs.AssignmentMenu {

  JComboBox<hacs.Solution> combSolutionList = new JComboBox<>();
  JTextField tbAssignmentName = new JTextField();
  JTextField tbDueDate = new JTextField();
  JTextField tbSuggestedSolution = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton buttonGrade = new JButton();
  JButton buttonReport = new JButton();
  JButton buttonClose = new JButton();
  private hacs.Solution theSolution;
  private hacs.Assignment theAssignment;

  public InstructorAssignmentMenu() {
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    jLabel1.setText("Assignment Name");
    jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
    this.getContentPane().setLayout(null);
    tbAssignmentName.setText("jTextField1");
    tbAssignmentName.setBounds(new Rectangle(192, 31, 341, 22));
    jLabel2.setText("Due Date");
    jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
    tbDueDate.setText("tbDueDate");
    tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
    jLabel3.setText("Suggested Solution");
    jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
    tbSuggestedSolution.setText("jTextField2");
    tbSuggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
    buttonGrade.setText("Grade");
    buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
    buttonGrade.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        buttonGrade_actionPerformed(e);
      }
    });
    buttonReport.setText("Report");
    buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
    buttonReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        buttonReport_actionPerformed(e);
      }
    });
    buttonClose.setText("Close");
    buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
    buttonClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        buttonClose_actionPerformed(e);
      }
    });
    combSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(tbAssignmentName, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(tbDueDate, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(tbSuggestedSolution, null);
    this.getContentPane().add(buttonClose, null);
    this.getContentPane().add(combSolutionList, null);
    this.getContentPane().add(buttonGrade, null);
    this.getContentPane().add(buttonReport, null);
  }

  public void showMenu(hacs.Assignment assignment, hacs.Person person) {
    theAssignment = assignment;
    tbAssignmentName.setText(theAssignment.assignmentName);
    DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
    tbSuggestedSolution.setText(theAssignment.suggestedSolution.solutionFileName);
    refreshSolutionList();
    setVisible(true);
  }

  void buttonClose_actionPerformed(ActionEvent e) {
    theAssignment.assignmentName = tbAssignmentName.getText();
    DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    try {
      theAssignment.dueDate = tempDateFormat.parse(tbDueDate.getText());
    } catch (Exception ee) {
    }
    ;
    theAssignment.suggestedSolution.solutionFileName = tbSuggestedSolution.getText();
    setVisible(false);
  }

  void buttonGrade_actionPerformed(ActionEvent e) {
    hacs.Solution theSolution = (hacs.Solution) combSolutionList.getSelectedItem();
    if (theSolution == null)
      return;
    hacs.SolutionGradingDlg dlg = new hacs.SolutionGradingDlg();
    dlg.show(theSolution);
    refreshSolutionList();
  }

  void buttonReport_actionPerformed(ActionEvent e) {
    hacs.SolutionIterator iter = new hacs.SolutionIterator(theAssignment.theSolutionList);
    while (iter.hasNext()) {
      hacs.Solution asolution = (hacs.Solution) iter.next();
      asolution.setReported(true);
    }
    refreshSolutionList();
  }

  private void refreshSolutionList() {
    combSolutionList.removeAllItems();
    hacs.SolutionIterator SolIter = new hacs.SolutionIterator(theAssignment.theSolutionList);
    while (SolIter.hasNext()) {
      theSolution = (hacs.Solution) SolIter.next();
      combSolutionList.addItem(theSolution);
    }
  }
}