package org.logart.shared;

import java.util.Date;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 4/22/14 8:23 PM
 */
public class Appointment {
	private final Date startDate;
	private final Date endDate;

	private final String description;

	private final PERIOD period;

	public Appointment(Date startDate, Date endDate, String description, PERIOD period) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.period = period;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getDescription() {
		return description;
	}

	public PERIOD getPeriod() {
		return period;
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"startDate=" + startDate +
				", endDate=" + endDate +
				", description='" + description + '\'' +
				", period=" + period +
				'}';
	}
}
