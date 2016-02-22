package com.sergioescudero.model.report;

public enum ReportStatus {

	// Pendientes de circularizar
	PENDING_SENT("PENDING_SENT", "Reports Pending to be Sent"),
	// Circularizados
	REPORT_SENT("REPORT_SENT", "Reports Sent"),
	// Pendientes de respuesta de sociedad receptora
	PENDING_RESPONSE("PENDING_RESPONSE", "Pending Response from Requested Company"),
	// Saldo confirmado
	BALANCE_CONFIRMED("BALANCE_CONFIRMED", "Balance Confirmed"),

	BALANCE_DIFFERENCES("BALANCE_DIFFERENCES", "Balance Differences"), BALANCE_REVIEWED("BALANCE_REVIEWED", "Reviewed"),

	// Pendiente de revision bajo sociedad emisora
	BALANCE_DIFF_UNDER_REVIEW("BALANCE_DIFF_UNDER_REVIEW", "Balance Differences Under Requester Company review"),
	// Diferencia en saldo conforme
	BALANCE_DIFF_REVIEWED_AGREE("BALANCE_DIFF_REVIEWED_AGREE", "Balance Differences Reviewed Agree"),
	// Diferencia en saldo no conforme
	BALANCE_DIFF_REVIEWED_DISAGREE("BALANCE_DIFF_REVIEWED_DISAGREE", "Balance Differences Reviewed Disagree"),
	// Diferencia en saldo con disputa
	BALANCE_DIFF_REVIEWED_DISPUTE("BALANCE_DIFF_REVIEWED_DISPUTE", "Balance Differences Reviewed Dispute"),

	CONCILIATION_OUTCOME("CONCILIATION_OUTCOME", "Conciliation Outcome"),

	// Total
	TOTAL("TOTAL", "Total");

	private String status;
	private String description;

	private ReportStatus(String status, String description) {
		this.status = status;
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}