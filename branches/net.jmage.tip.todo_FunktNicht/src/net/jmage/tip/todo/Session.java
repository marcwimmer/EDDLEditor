package net.jmage.tip.todo;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import net.jmage.tip.todo.domain.TodoItem;
import net.jmage.tip.todo.domain.TodoList;

public class Session {
	public static TodoList list;
	
	public static TodoList getModel() {
		if (list != null) return list;
		TodoItem root = new TodoItem("root");
		TodoItem child1= new TodoItem("Martini");
		TodoItem child1a = new TodoItem("5cl Gin");
		child1a.setComplete(true);
		child1.addChild(child1a);
		child1.addChild(new TodoItem("1cl Vermouth"));
		child1.addChild(new TodoItem("Olive"));
		root.addChild(child1);
		root.addChild(new TodoItem("Zubereitung"));
		root.addChild(new TodoItem("Tipps"));
		list = new TodoList(root);
		
		return list;
	}
	
    public enum TodoIcon {
        COMPLETE("icons/complete.png"), INCOMPLETE("icons/incomplete.png"), P000(
                "icons/000.png"), P025("icons/025.png"), P050("icons/050.png"), P075(
                "icons/075.png"), P100("icons/100.png");

        private final String filename;

        private TodoIcon(String filename) {
            this.filename = filename;
        }

        public ImageDescriptor getImage() {
            return AbstractUIPlugin.imageDescriptorFromPlugin(
                    Application.PLUGIN_ID, filename);
        }
    }
    /**
     * Returns the correct icon for the given item.
     * <p>
     * 
     * If this item is a leaf, a checkbox will be shown (checked or unchecked,
     * depending on {@link #isComplete}.
     * <p>
     * 
     * If the item is a node, a progress bar will be shown.
     */
    public static ImageDescriptor getIcon(TodoItem item) {
        if (item.getChildCount() == 0) {
            return item.getCompletion().isComplete() ? Session.TodoIcon.COMPLETE
                    .getImage()
                    : Session.TodoIcon.INCOMPLETE.getImage();
        }

        int p = item.getCompletion().getPercentage();
        if (p < 25)
            return Session.TodoIcon.P000.getImage();
        if (p < 50)
            return Session.TodoIcon.P025.getImage();
        if (p < 75)
            return Session.TodoIcon.P050.getImage();
        if (p < 100)
            return Session.TodoIcon.P075.getImage();
        if (p == 100)
            return Session.TodoIcon.P100.getImage();
        throw new AssertionError("Percentage: " + p);
    }
}
