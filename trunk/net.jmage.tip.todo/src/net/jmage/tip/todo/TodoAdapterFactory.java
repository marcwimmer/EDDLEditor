package net.jmage.tip.todo;

import net.jmage.tip.todo.domain.TodoItem;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class TodoAdapterFactory implements IAdapterFactory {
	private IWorkbenchAdapter todoAdapter = new IWorkbenchAdapter() {

		@Override
		public Object[] getChildren(Object o) {
			TodoItem item = (TodoItem) o;
			return item.getChildren();
		}

		@Override
		public ImageDescriptor getImageDescriptor(Object o) {
			TodoItem item = (TodoItem) o;
			return Session.getIcon(item);
		}

		@Override
		public String getLabel(Object o) {
			TodoItem item = (TodoItem) o;
			if (item.getChildCount() == 0)
				return item.getTitle();
			return item.getTitle() + " ("
					+ item.getCompletion().getPercentage() + "%)";

		}

		@Override
		public Object getParent(Object o) {
			TodoItem item = (TodoItem) o;
			return item.getParent();
		}

	};

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof TodoItem
				&& adapterType == IWorkbenchAdapter.class)
			return todoAdapter;
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { IWorkbenchAdapter.class };
	}

}
