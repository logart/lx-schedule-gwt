package org.logart.shared;

import com.google.gwt.i18n.shared.DateTimeFormat;
import org.joda.time.DateTime;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:23 PM
 */
public class Appointment {
	private String description;
	private DateTimeFormat time;

	public Appointment() {

	}

	public Appointment(String description, DateTimeFormat time) {
		this.description = description;
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTimeFormat getTime() {
		return time;
	}

	public void setTime(DateTimeFormat time) {
		this.time = time;
	}
}
