package org.logart.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import org.logart.client.presenters.AppointmentPresenter;
import org.logart.shared.Appointment;
import org.logart.shared.PERIOD;

import java.util.Date;
import java.util.List;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:44 PM
 */
public class AppointmentView extends Composite implements AppointmentPresenter.Display {
	private static AppointmentViewUiBinder uiBinder = GWT.create(AppointmentViewUiBinder.class);

	@UiField
	CellTable<Appointment> table;

	@UiField
	Button button;

	@UiField
	TextBox startDate;

	@UiField
	TextBox startTime;

	@UiField
	TextBox endDate;

	@UiField
	TextBox endTime;

	@UiField
	TextBox description;

	@UiField
	ListBox period;

	private AppointmentPresenter presenter;

	interface AppointmentViewUiBinder extends UiBinder<Widget, AppointmentView> {
	}

	public AppointmentView() {
		initWidget(uiBinder.createAndBindUi(this));

		TextColumn<Appointment> startTimeColumn = new TextColumn<Appointment>() {
			@Override
			public String getValue(Appointment object) {
				return object == null ? "default descr" : object.getStartDate().toString();
			}
		};

		TextColumn<Appointment> startDateColumn = new TextColumn<Appointment>() {
			@Override
			public String getValue(Appointment object) {
				return object == null ? "default descr" : object.getStartDate().toString();
			}
		};

		TextColumn<Appointment> endTimeColumn = new TextColumn<Appointment>() {
			@Override
			public String getValue(Appointment object) {
				return object == null ? "default descr" : object.getEndDate().toString();
			}
		};

		TextColumn<Appointment> endDateColumn = new TextColumn<Appointment>() {
			@Override
			public String getValue(Appointment object) {
				return object == null ? "default descr" : object.getEndDate().toString();
			}
		};

		TextColumn<Appointment> descriptionColumn = new TextColumn<Appointment>() {
			@Override
			public String getValue(Appointment object) {
				return object == null ? "default descr" : object.getDescription();
			}
		};

		TextColumn<Appointment> periodColumn = new TextColumn<Appointment>() {
			@Override
			public String getValue(Appointment object) {
				return object == null ? "default descr" : object.getPeriod().name();
			}
		};

		table.addColumn(startTimeColumn, "Start time");
		table.addColumn(startDateColumn, "Start date");
		table.addColumn(endTimeColumn, "End time");
		table.addColumn(endDateColumn, "End time");
		table.addColumn(descriptionColumn, "Description");
		table.addColumn(periodColumn, "Period");


	}

	@Override
	public void clear() {
		setDescription("");
	}

	@Override
	public void setDescription(String description) {

	}

	@Override
	public void setPresenter(AppointmentPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setData(List<Appointment> model) {
		table.setRowData(model);
		table.redraw();
	}

	@UiHandler("button")
	void onClick(ClickEvent event) {
		if (presenter != null) {
			//todo more beautiful binding?
			Appointment appointment = new Appointment(
					toDate(startDate.getText(), startTime.getText()),
					toDate(endDate.getText(), endTime.getText()),
					description.getText(),
					toPeriod(period.getSelectedIndex())
			);
			presenter.addAppointment(
					appointment
			);
		}
	}

	private PERIOD toPeriod(int selected) {
		return PERIOD.valueOf(selected);
	}

	private Date toDate(String date, String time) {
		return new Date();    //todo convert
	}
}
