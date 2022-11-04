package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class NodeVisitor {

	public NodeVisitor() {
	}

	public NodeVisitor(Object visited) {
	}

	abstract public void visitFacade(hacs.Facade facade);

	abstract public void visitCourse(hacs.Course course);

	abstract public void visitAssignment(hacs.Assignment assignment);

}