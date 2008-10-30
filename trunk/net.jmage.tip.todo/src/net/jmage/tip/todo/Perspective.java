package net.jmage.tip.todo;

import org.eclipse.swt.SWT;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addStandaloneView(TodoListView.ID, false, SWT.LEFT, 0.5f, layout
				.getEditorArea());
		layout.setEditorAreaVisible(false); //Editor abschalten
	}
}
