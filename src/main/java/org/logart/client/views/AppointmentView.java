package org.logart.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import org.logart.client.presenters.AppointmentPresenter;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:44 PM
 */
public class AppointmentView extends Composite implements AppointmentPresenter.Display {
	private static AppointmentViewUiBinder uiBinder = GWT.create(AppointmentViewUiBinder.class);

	@UiField
	Button button;

	@UiField
	Label description;

	private AppointmentPresenter presenter;

	interface AppointmentViewUiBinder extends UiBinder<Widget, AppointmentView> {
	}

	public AppointmentView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public AppointmentView(String description) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(description);
	}

	@Override
	public void clear() {
		setDescription("");
	}

	@Override
	public void setDescription(String description) {
		this.description.setText(description);
	}

	@Override
	public void setPresenter(AppointmentPresenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("button")
	void onClick(ClickEvent event) {
		if (presenter != null) {
			presenter.showDateTime();
		}
	}
}
