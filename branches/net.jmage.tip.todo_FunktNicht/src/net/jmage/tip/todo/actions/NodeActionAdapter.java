package net.jmage.tip.todo.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import net.jmage.tip.todo.domain.TodoItem;

public abstract class NodeActionAdapter implements IObjectActionDelegate {
	private TodoItem item;

	public abstract void run(TodoItem item);

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void run(IAction action) {
		if (item != null)
			run(item);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		item = null;
		if (!(selection instanceof IStructuredSelection))
			return;
		if (((IStructuredSelection) selection).size() != 1)
			return;
		item = (TodoItem) ((IStructuredSelection) selection).getFirstElement();
		action.setEnabled(item != null);
	}
}
