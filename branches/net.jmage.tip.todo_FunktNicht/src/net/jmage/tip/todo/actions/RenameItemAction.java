package net.jmage.tip.todo.actions;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;

import net.jmage.tip.todo.domain.TodoItem;

public class RenameItemAction extends NodeActionAdapter {
	public static String ID = "net.jmage.tip.todo.contextMenu.renameChild";

	@Override
	public void run(TodoItem item) {
		InputDialog dialog = new InputDialog(null, "Rename item",
				"Please select a new name", item.getTitle(), null);

		int status = dialog.open();
		if (status != Window.OK)
			return;
		String newTitle = dialog.getValue().trim();
		if (newTitle.equals(""))
			return;
		item.setTitle(newTitle);
	}

}
