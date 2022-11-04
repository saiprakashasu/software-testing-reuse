package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.text.DateFormat;
import java.util.Date;

public class Assignment {

  protected String assignmentName;
  protected String strAssignmentFileName;
  protected Date dueDate = new Date();
  protected String assignmentSpec;
  protected hacs.SolutionList theSolutionList = new hacs.SolutionList();
  protected hacs.Solution suggestedSolution = new hacs.Solution();

  public Assignment() {
  }

  public void setDueDate(Date theDueDate) {
    this.dueDate = theDueDate;
  }

  public void setAssignmentSpec(String theSpec) {
    this.assignmentSpec = theSpec;
  }

  public boolean isOverDue() {
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  public hacs.Solution addSolution() {
    hacs.Solution mySolution = new hacs.Solution();
    return mySolution;
  }

  //// add the theSolution to the Solutionlist
  public void addSolution(hacs.Solution theSolution) {
    theSolutionList.add(theSolution);
  }

  public void submitSolution() {
  }

  public void getSolutionList() {
  }

  /*
   * return the solution of the give name
   */
  public hacs.Solution getSolution(String studentName) {
    hacs.SolutionIterator Iterator = new hacs.SolutionIterator(theSolutionList);
    return Iterator.next(studentName);
  }

  public hacs.Solution getSuggestedSolution() {
    return suggestedSolution;
  }

  public hacs.SolutionIterator getSolutionIterator() {
    hacs.SolutionIterator theSolutionIterator = new hacs.SolutionIterator(theSolutionList);
    return theSolutionIterator;
  }

  public String toString() {
    return assignmentName;
  }

  public String getDueDateString() {
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    return dateFormat.format(dueDate);
  }

  public void accept(hacs.NodeVisitor visitor) {
    visitor.visitAssignment(this);
  }
}