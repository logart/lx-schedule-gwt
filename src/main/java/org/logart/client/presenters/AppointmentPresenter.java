package org.logart.client.presenters;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import org.logart.shared.Appointment;

import java.util.List;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:33 PM
 */
public class AppointmentPresenter implements Presenter {
	Display view;
	private List<Appointment> appointments;

	public interface Display {
		void clear();

		void setDescription(String description);

		Widget asWidget();

		void setPresenter(AppointmentPresenter presenter);

		void setData(List<Appointment> model);
	}

	public AppointmentPresenter(List<Appointment> appointments, Display view) {
		this.appointments = appointments;
		this.view = view;

		bind();//todo find more beautiful way;
	}

	@Override
	public void bind() {
		view.setPresenter(this);
		view.clear();

		view.setData(appointments);
	}

	@Override
	public void go(Panel panel) {
		panel.add(view.asWidget());
	}

	@Override
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		bind();
	}
}
