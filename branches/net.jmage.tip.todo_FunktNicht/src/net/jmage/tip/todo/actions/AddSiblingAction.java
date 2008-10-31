package net.jmage.tip.todo.actions;

import net.jmage.tip.todo.domain.TodoItem;

public class AddSiblingAction extends NodeActionAdapter {
	public static String ID = "net.jmage.tip.todo.contextMenu.addSibling";
	
	@Override
	public void run(TodoItem item) {
		item.addSibling(new TodoItem("New Sibling"), false);
	}

}
