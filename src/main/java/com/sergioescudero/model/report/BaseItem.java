package com.sergioescudero.model.report;

import java.io.Serializable;
import java.util.Map;

/**
 * Clase base que contiene atributos comunes de Item y Report
 *
 */
public abstract class BaseItem implements Serializable {

	private static final long serialVersionUID = 9195273256857525622L;

	// SOC_GL_REQUESTER
	protected String requesterHfm;
	// NOMBRE_REQUESTER
	protected String requesterCompanyName;
	// SOC_GL_REQUESTED
	protected String requestedHfm;
	// NOMBRE_REQUESTED
	protected String requestedCompanyName;
	protected double dmbtr;
	protected String hwaer;
	// CAMPOS relacionados con la moneda de reconciliacion
	// no van a venir de SAP, los tenemos que calcular
	protected double currencyReconciliationVal;
	protected String currencyReconciliation;

	protected double diff;
	protected double diffRC;

	protected String diffWaers;
	protected String diffCurrencyReconciliation;

	private Map<String, Double> currencyReconciliationMap;
	private Map<String, Item> hfmSummaryMap;

	// ANYO
	protected int fiscalYear;
	// MES
	protected int period;

	protected boolean notPosted = false;

	protected boolean completed = false;
	protected boolean completedValidation = false;

	// cuando devolvamos un report
	// a flex mandamos si se ha rellenado
	// correctamente o no
	private boolean success;

	private String intraco;

	public String getIntraco() {
		return intraco;
	}

	public void setIntraco(String intraco) {
		this.intraco = intraco;
	}

	public String getRequesterHfm() {
		return requesterHfm;
	}

	public void setRequesterHfm(String requesterHfm) {
		this.requesterHfm = requesterHfm;
	}

	public String getRequesterCompanyName() {
		return requesterCompanyName;
	}

	public void setRequesterCompanyName(String requesterCompanyName) {
		this.requesterCompanyName = requesterCompanyName;
	}

	public String getRequestedHfm() {
		return requestedHfm;
	}

	public void setRequestedHfm(String requestedHfm) {
		this.requestedHfm = requestedHfm;
	}

	public String getRequestedCompanyName() {
		return requestedCompanyName;
	}

	public void setRequestedCompanyName(String requestedCompanyName) {
		this.requestedCompanyName = requestedCompanyName;
	}

	public double getDmbtr() {
		return dmbtr;
	}

	public void setDmbtr(double dmbtr) {
		this.dmbtr = dmbtr;
	}

	public String getHwaer() {
		return hwaer;
	}

	public void setHwaer(String hwaer) {
		this.hwaer = hwaer;
	}

	public double getCurrencyReconciliationVal() {
		return currencyReconciliationVal;
	}

	public void setCurrencyReconciliationVal(double currencyReconciliationVal) {
		this.currencyReconciliationVal = currencyReconciliationVal;
	}

	public String getCurrencyReconciliation() {
		return currencyReconciliation;
	}

	public void setCurrencyReconciliation(String currencyReconciliation) {
		this.currencyReconciliation = currencyReconciliation;
	}

	/**
	 * @return the notPosted
	 */
	public boolean isNotPosted() {
		return notPosted;
	}

	/**
	 * @param notPosted
	 *            the notPosted to set
	 */
	public void setNotPosted(boolean notPosted) {
		this.notPosted = notPosted;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public double getDiff() {
		return diff;
	}

	public void setDiff(double diff) {
		this.diff = diff;
	}

	public double getDiffRC() {
		return diffRC;
	}

	public void setDiffRC(double diffRC) {
		this.diffRC = diffRC;
	}

	public String getDiffWaers() {
		return diffWaers;
	}

	public void setDiffWaers(String diffWaers) {
		this.diffWaers = diffWaers;
	}

	public String getDiffCurrencyReconciliation() {
		return diffCurrencyReconciliation;
	}

	public void setDiffCurrencyReconciliation(String diffCurrencyReconciliation) {
		this.diffCurrencyReconciliation = diffCurrencyReconciliation;
	}

	public Map<String, Double> getCurrencyReconciliationMap() {
		return currencyReconciliationMap;
	}

	public void setCurrencyReconciliationMap(Map<String, Double> currencyReconciliationMap) {
		this.currencyReconciliationMap = currencyReconciliationMap;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Item> getHfmSummaryMap() {
		return hfmSummaryMap;
	}

	public void setHfmSummaryMap(Map<String, Item> hfmSummaryMap) {
		this.hfmSummaryMap = hfmSummaryMap;
	}

	public boolean isCompletedValidation() {
		return completedValidation;
	}

	public void setCompletedValidation(boolean completedValidation) {
		this.completedValidation = completedValidation;
	}

	protected Object copyProperties(BaseItem base) {
		base.setRequesterHfm(requesterHfm);
		base.setRequesterCompanyName(requesterCompanyName);
		base.setRequestedHfm(requestedHfm);
		base.setRequestedCompanyName(requestedCompanyName);
		base.setDmbtr(dmbtr);
		base.setHwaer(hwaer);
		base.setCurrencyReconciliationVal(currencyReconciliationVal);
		base.setCurrencyReconciliation(currencyReconciliation);
		base.setDiff(diff);
		base.setDiffRC(diffRC);
		base.setDiffWaers(diffWaers);
		base.setDiffCurrencyReconciliation(diffCurrencyReconciliation);
		base.setFiscalYear(fiscalYear);
		base.setPeriod(period);
		base.setNotPosted(notPosted);
		base.setCompleted(completed);
		base.setCompletedValidation(completedValidation);
		base.setCurrencyReconciliationMap(currencyReconciliationMap);
		base.setSuccess(success);
		base.setIntraco(intraco);
		return base;
	}

	public void clear() {
		currencyReconciliationMap.clear();
		hfmSummaryMap.clear();
	}

}
