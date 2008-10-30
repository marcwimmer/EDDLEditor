package net.jmage.tip.todo.actions;

import net.jmage.tip.todo.domain.TodoItem;

public class AddChildAction extends NodeActionAdapter {
	public static String ID = "net.jmage.tip.todo.contextMenu.addChild";

	@Override
	public void run(TodoItem item) {
		item.addChild(new TodoItem("Child Item"));
	}

}
