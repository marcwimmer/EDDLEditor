package net.jmage.tip.todo.actions;

import net.jmage.tip.todo.domain.TodoItem;

public class RemoveItemAction extends NodeActionAdapter {
	public static String ID = "net.jmage.tip.todo.contextMenu.removeItem";
	@Override
	public void run(TodoItem item) {
		item.removeItem();
	}

}
