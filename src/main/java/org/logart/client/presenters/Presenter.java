package org.logart.client.presenters;

import com.google.gwt.user.client.ui.Panel;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:32 PM
 */
public interface Presenter {
	public void bind();
	public void go(Panel panel);
}
