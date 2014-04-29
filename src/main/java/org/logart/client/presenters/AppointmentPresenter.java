package org.logart.client.presenters;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import org.logart.shared.Appointment;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:33 PM
 */
public class AppointmentPresenter implements Presenter {
	Appointment appointment;
	Display view;

	public interface Display {
		public void clear();

		public void setDescription(String description);

		public Widget asWidget();

		public void setPresenter(AppointmentPresenter presenter);
	}

	public AppointmentPresenter(Appointment appointment, Display view) {
		this.appointment = appointment;
		this.view = view;

		bind();//todo find more beautiful way;
	}

	@Override
	public void bind() {
		view.setPresenter(this);
		view.clear();
		view.setDescription(appointment.getDescription());
	}

	@Override
	public void go(Panel panel) {
		panel.add(view.asWidget());
	}

	public void showDateTime() {
		view.setDescription(appointment.getDescription() + " at " + appointment.getTime());
	}
}
