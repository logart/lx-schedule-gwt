package org.logart.client.presenters;

import com.google.gwt.user.client.ui.Panel;
import org.logart.shared.Appointment;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:32 PM
 */
public interface Presenter {
	void bind();
	void go(Panel panel);

	void addAppointment(Appointment appointment);
}
