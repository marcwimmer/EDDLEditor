package net.jmage.tip.todo;

import net.jmage.tip.todo.domain.ITodoListener;
import net.jmage.tip.todo.domain.TodoItem;
import net.jmage.tip.todo.domain.TodoList;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;

public class TodoListView extends ViewPart {

	public static String ID = "net.jmage.tip.todo.view.todolist";

	private CheckboxTreeViewer tree;

	public TodoListView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		tree = new CheckboxTreeViewer(parent);
		tree.setLabelProvider(new WorkbenchLabelProvider());
		tree.setContentProvider(new BaseWorkbenchContentProvider());
		TodoList list = Session.getModel();
		setModel(list);
		initContextMenu();
		// Broadcast selection events to the Workbench
		getSite().setSelectionProvider(tree);

		// Make sure that the tree redraws when items change.
		list.addTodoListener(new ITodoListener() {
			public void itemAdded(TodoItem item) {
				tree.refresh(item.getParent());
			}

			public void itemChanged(TodoItem item) {
				tree.refresh(item);
			}

		});

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void setModel(TodoList list) {
		tree.setInput(list.getRoot());
	}

	private void initContextMenu() {
		// Provide a hook for the Context Menu
		MenuManager manager = new MenuManager("net.jmage.tip.todo.contextMenu");
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		Menu menu = manager.createContextMenu(tree.getControl());
		tree.getControl().setMenu(menu);
		getSite().registerContextMenu(manager, tree);

	}
}
