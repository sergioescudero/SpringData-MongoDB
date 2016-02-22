package com.sergioescudero.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report extends BaseItem implements Serializable {

	private static final long serialVersionUID = -72042030931951781L;
	private String id;

	// id del primer report del que se ha partido
	// como los ids van cambiando cada vez que se
	// guardan cambios la mejor manera de referenciarlos
	// en la cache es por su id original
	private String reportSourceId;
	private String reportSourceRel;

	// SOC_FI_REQUESTER
	private String requesterCompanyId;
	// SOC_FI_REQUESTED
	private String requestedCompanyId;
	private String dateCreation;
	private String timeCreation;
	private Date sendDate;

	private Date creationDate;

	private ItemList requesterItems;
	private ItemList requestedItems;
	private ItemList balanceItems;
	private ItemList invoiceItems;

	private List<ReportStatus> reportStatusList = new ArrayList<ReportStatus>();
	private Date modificationDate;
	private String lastModifiedBy;

	private List<Note> observations = new ArrayList<Note>();

	// esta variable solo se rellenara
	// cuando el requester responda
	// que hay un error
	private boolean hasError;

	// si success = false
	// metemos el mensaje de error
	private String errorMessage;
	// si success = false
	// metemos el mensaje de error si procede
	private String errorCode;

	// fecha programada para cerrar un report
	private Date closeReportTime;

	// flag que indica si un report marcado con 'closeReportTime' ha sido ya
	// cerrado o no
	private boolean closed;

	// flag que indica si la requestedCompany ha realizado alguna modificacion
	// en el fichero
	private boolean requestedMakeChanges;

	private List<Item> complexInvoiceItemList = new ArrayList<Item>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the reportSourceId
	 */
	public String getReportSourceId() {
		if (reportSourceId != null) {
			return reportSourceId;
		} else {
			return id;
		}
	}

	/**
	 * @param reportSourceId
	 *            the reportSourceId to set
	 */
	public void setReportSourceId(String reportSourceId) {
		this.reportSourceId = reportSourceId;
	}

	/**
	 * @return the requesterCompanyId
	 */
	public String getRequesterCompanyId() {
		return requesterCompanyId;
	}

	/**
	 * @param requesterCompanyId
	 *            the requesterCompanyId to set
	 */
	public void setRequesterCompanyId(String requesterCompanyId) {
		this.requesterCompanyId = requesterCompanyId;
	}

	/**
	 * @return the requestedCompanyId
	 */
	public String getRequestedCompanyId() {
		return requestedCompanyId;
	}

	/**
	 * @param requestedCompanyId
	 *            the requestedCompanyId to set
	 */
	public void setRequestedCompanyId(String requestedCompanyId) {
		this.requestedCompanyId = requestedCompanyId;
	}

	/**
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the timeCreation
	 */
	public String getTimeCreation() {
		return timeCreation;
	}

	/**
	 * @param timeCreation
	 *            the timeCreation to set
	 */
	public void setTimeCreation(String timeCreation) {
		this.timeCreation = timeCreation;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the requesterItemList
	 */
	public List<Item> getRequesterItemList() {
		return getItemList(requesterItems);
	}

	/**
	 * @return the requestedItemList
	 */
	public List<Item> getRequestedItemList() {
		return getItemList(requestedItems);
	}

	/**
	 * @return the balanceItemList
	 */
	public List<Item> getBalanceItemList() {
		return getItemList(balanceItems);
	}

	/**
	 * @return the invoiceItemList
	 */
	public List<Item> getInvoiceItemList() {
		return getItemList(invoiceItems);
	}

	/**
	 * @return the requesterItems
	 */
	public ItemList getRequesterItems() {
		return requesterItems;
	}

	/**
	 * @param requesterItems
	 *            the requesterItems to set
	 */
	public void setRequesterItems(ItemList requesterItems) {
		this.requesterItems = requesterItems;
	}

	/**
	 * @return the requestedItems
	 */
	public ItemList getRequestedItems() {
		return requestedItems;
	}

	/**
	 * @param requestedItems
	 *            the requestedItems to set
	 */
	public void setRequestedItems(ItemList requestedItems) {
		this.requestedItems = requestedItems;
	}

	/**
	 * @return the balanceItems
	 */
	public ItemList getBalanceItems() {
		return balanceItems;
	}

	/**
	 * @param balanceItems
	 *            the balanceItems to set
	 */
	public void setBalanceItems(ItemList balanceItems) {
		this.balanceItems = balanceItems;
	}

	/**
	 * @return the invoiceItems
	 */
	public ItemList getInvoiceItems() {
		return invoiceItems;
	}

	/**
	 * @param invoiceItems
	 *            the invoiceItems to set
	 */
	public void setInvoiceItems(ItemList invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the reportStatusList
	 */
	public List<ReportStatus> getReportStatusList() {
		return reportStatusList;
	}

	/**
	 * @param reportStatusList
	 *            the reportStatusList to set
	 */
	public void setReportStatusList(List<ReportStatus> reportStatusList) {
		this.reportStatusList = reportStatusList;
	}

	public String getStatus() {
		String status = ReportStatus.PENDING_SENT.getStatus();
		if (reportStatusList != null && reportStatusList.size() > 0)
			status = reportStatusList.get(0).getStatus();

		return status;
	}

	public void setStatus(String status) {

	}

	public List<String> getStatusList() {
		List<String> statusList = new ArrayList<String>();
		for (ReportStatus reportStatus : reportStatusList) {
			statusList.add(reportStatus.getStatus());
		}

		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		if (statusList != null) {
			String mainstatus = statusList.get(0);
			ReportStatus reportStatus = statusToReportStatusConversion(mainstatus);
			changeReportStatus(reportStatus, null);
			statusList.remove(0);
		}
		for (String status : statusList) {
			ReportStatus reportStatus = statusToReportStatusConversion(status);
			addAdditonalReportStatus(reportStatus);
		}
	}

	public List<Item> getComplexInvoiceItemList() {
		return complexInvoiceItemList;
	}

	public void setComplexInvoiceItemList(List<Item> complexInvoiceItemList) {
		this.complexInvoiceItemList = complexInvoiceItemList;
	}

	private ReportStatus statusToReportStatusConversion(String status) {
		boolean find = false;
		ReportStatus[] reportStatusList = ReportStatus.values();
		int i = 0;
		ReportStatus reportStatus = null;
		while (!find && i < reportStatusList.length) {
			reportStatus = reportStatusList[i];

			if (reportStatus.getStatus().equalsIgnoreCase(status)) {
				find = true;
			}
			i++;

		}
		if (!find) {
			reportStatus = null;
		}

		return reportStatus;
	}

	/**
	 * Metodo para cambiar el estado de un report, por lo que borra su lista e
	 * introduce el nuevo estado que se quiere guardar
	 * 
	 * @param status
	 */
	public void changeReportStatus(ReportStatus status, String modifiedBy) {
		reportStatusList = new ArrayList<ReportStatus>();
		reportStatusList.add(status);
		if (modifiedBy != null) {
			modificationDate = new Date();
			lastModifiedBy = modifiedBy;
		}
	}

	/**
	 * Metodo para a�adir un estado a un report, a diferencia del metodo
	 * anterior changeReportStatus(ReportStatus status) este no borra la lista
	 * de estados
	 * 
	 * @param status
	 */
	public void addAdditonalReportStatus(ReportStatus status) {
		reportStatusList.add(status);
	}

	private List<Item> getItemList(ItemList itemList) {
		if (itemList != null)
			return itemList.getList();
		else
			return null;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate
	 *            the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * @return the observations
	 */
	public List<Note> getObservations() {
		return observations;
	}

	/**
	 * @param observations
	 *            the observations to set
	 */
	public void setObservations(List<Note> observations) {
		this.observations = observations;
	}

	/**
	 * @return the sendDate
	 */
	public Date getSendDate() {
		return sendDate;
	}

	/**
	 * @param sendDate
	 *            the sendDate to set
	 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	/**
	 * @return the hasError
	 */
	public boolean isHasError() {
		return hasError;
	}

	/**
	 * @param hasError
	 *            the hasError to set
	 */
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the closeReportTime
	 */
	public Date getCloseReportTime() {
		return closeReportTime;
	}

	/**
	 * @param closeReportTime
	 *            the closeReportTime to set
	 */
	public void setCloseReportTime(Date closeReportTime) {
		this.closeReportTime = closeReportTime;
	}

	/**
	 * @return the closed
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * @param closed
	 *            the closed to set
	 */
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	/**
	 * @return the requestedMakeChanges
	 */
	public boolean isRequestedMakeChanges() {
		return requestedMakeChanges;
	}

	/**
	 * @param requestedMakeChanges
	 *            the requestedMakeChanges to set
	 */
	public void setRequestedMakeChanges(boolean requestedMakeChanges) {
		this.requestedMakeChanges = requestedMakeChanges;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Report [id=" + id + ", reportStatusList=" + reportStatusList + "]";
	}

	public String getReportSourceRel() {
		return reportSourceRel;
	}

	public void setReportSourceRel(String reportSourceRel) {
		this.reportSourceRel = reportSourceRel;
	}

	@Override
	public Object clone() {
		return clone(false);
	}

	public Object clone(boolean recursive) {
		Report clone = new Report();
		clone = (Report) super.copyProperties(clone);
		clone.setId(id);
		clone.setReportSourceId(reportSourceId);
		clone.setReportSourceRel(reportSourceRel);
		clone.setRequesterCompanyId(requesterCompanyId);
		clone.setRequestedCompanyId(requestedCompanyId);
		clone.setDateCreation(dateCreation);
		clone.setTimeCreation(timeCreation);
		clone.setSendDate(sendDate);
		clone.setCreationDate(creationDate);

		if (requesterItems != null)
			clone.setRequesterItems((ItemList) requesterItems.clone(recursive));
		if (requestedItems != null)
			clone.setRequestedItems((ItemList) requestedItems.clone(recursive));

		if (balanceItems != null) {
			clone.setBalanceItems((ItemList) balanceItems.clone(recursive));
			clone.setInvoiceItems((ItemList) balanceItems.clone(recursive));
		}

		// lista de ENUMS
		List<ReportStatus> newReportStatusList = new ArrayList<ReportStatus>(reportStatusList);
		List<Note> newObservations;
		List<Item> newComplexInvoiceItemList;
		if (recursive) {
			newObservations = CloneUtils.cloneList(observations);
			newComplexInvoiceItemList = CloneUtils.cloneList(complexInvoiceItemList);
		} else {
			newObservations = new ArrayList<Note>(observations);
			newComplexInvoiceItemList = new ArrayList<Item>(complexInvoiceItemList);
		}
		clone.setReportStatusList(newReportStatusList);
		clone.setObservations(newObservations);
		clone.setComplexInvoiceItemList(newComplexInvoiceItemList);
		clone.setModificationDate(modificationDate);
		clone.setLastModifiedBy(lastModifiedBy);
		clone.setHasError(hasError);
		clone.setErrorMessage(errorMessage);
		clone.setErrorCode(errorCode);
		clone.setCloseReportTime(closeReportTime);
		clone.setClosed(closed);
		clone.setRequestedMakeChanges(requestedMakeChanges);
		return clone;
	}

	public Report cloneForListing(boolean recursive) {
		Report clone = new Report();
		clone = (Report) super.copyProperties(clone);
		clone.setId(id);
		clone.setReportSourceId(reportSourceId);
		clone.setReportSourceRel(reportSourceRel);
		clone.setRequesterCompanyId(requesterCompanyId);
		clone.setRequestedCompanyId(requestedCompanyId);
		clone.setDateCreation(dateCreation);
		clone.setTimeCreation(timeCreation);
		clone.setSendDate(sendDate);
		clone.setCreationDate(creationDate);

		// clone.setRequesterItems((ItemList)requesterItems.clone(recursive));
		// clone.setRequestedItems((ItemList)requestedItems.clone(recursive));
		// clone.setBalanceItems((ItemList)balanceItems.clone(recursive));
		// clone.setInvoiceItems((ItemList)balanceItems.clone(recursive));

		// lista de ENUMS
		List<ReportStatus> newReportStatusList = new ArrayList<ReportStatus>(reportStatusList);
		List<Note> newObservations;
		if (recursive) {
			newObservations = CloneUtils.cloneList(observations);
			// newComplexInvoiceItemList =
			// CloneUtils.cloneList(complexInvoiceItemList);
		} else {
			newObservations = new ArrayList<Note>(observations);
			// newComplexInvoiceItemList = new
			// ArrayList<Item>(complexInvoiceItemList);
		}
		clone.setReportStatusList(newReportStatusList);
		clone.setObservations(newObservations);
		// clone.setComplexInvoiceItemList(newComplexInvoiceItemList);
		clone.setModificationDate(modificationDate);
		clone.setLastModifiedBy(lastModifiedBy);
		clone.setHasError(hasError);
		clone.setErrorMessage(errorMessage);
		clone.setErrorCode(errorCode);
		clone.setCloseReportTime(closeReportTime);
		clone.setClosed(closed);
		clone.setRequestedMakeChanges(requestedMakeChanges);
		return clone;
	}

	@Override
	public void clear() {
		super.clear();
		requesterItems.clear();
		requestedItems.clear();
		balanceItems.clear();
		invoiceItems.clear();

		reportStatusList.clear();
		observations.clear();

		complexInvoiceItemList.clear();

	}

	public void clearInvoiceItems() {
		requesterItems.clear();
		requestedItems.clear();
		invoiceItems.clear();

	}

}
