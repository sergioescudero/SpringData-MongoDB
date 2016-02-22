package com.sergioescudero.model.report;

import java.util.Date;

public class Item extends BaseItem implements Cloneable {

	private static final long serialVersionUID = -4860276743781158418L;

	// variable extra para identificar las partidas
	private Integer itemId;

	private String codSocGlRequester;
	private String codSocGlRequested;
	private String belnr;
	private String bukrs;
	private int gjahr;
	private String buzei;
	private String blart;
	private String blartLtext;
	private Date bldat;
	private Date budat;
	private Date cpudt;
	private String xblnr;
	private String xref1;
	private String xref2;
	private String xref3;
	private String account;
	private String type;
	private double wrbtr;
	private String waers;
	private String name1;
	private String extKey;
	private String caseTitle;

	// adicionales
	private String differences;
	private Note intercompanyNote;

	private String differencesRequested = "";

	private Note requestedNote;
	private String requestedReview;

	private String differencesRequester = "";
	private Note intercompanyRequesterNote;

	private String requesterReview;
	private Note requesterNote;

	private String reportSourceId;
	private String reportSourceRel;

	private double timing = 0D;
	private double dispute = 0D;
	private double fx = 0D;

	/**
	 * En caso de que una partida se corresponda con la de otro xml en relacion
	 * 1 : 1 se indicará en este campo con cual. Si no hay relacion o es
	 * multiple sera NULL
	 */
	private Integer itemRef;
	/**
	 * Si una partida se corresponde con varias del otro xml 1 : N o N : N se
	 * indicara con multipleRef=true para relaciones 1:1 o sin relacion
	 * multipleRef=false
	 */
	private boolean multipleRef = false;

	private String status;

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the codSocGlRequester
	 */
	public String getCodSocGlRequester() {
		return codSocGlRequester;
	}

	/**
	 * @param codSocGlRequester
	 *            the codSocGlRequester to set
	 */
	public void setCodSocGlRequester(String codSocGlRequester) {
		this.codSocGlRequester = codSocGlRequester;
	}

	/**
	 * @return the codSocGlRequested
	 */
	public String getCodSocGlRequested() {
		return codSocGlRequested;
	}

	/**
	 * @param codSocGlRequested
	 *            the codSocGlRequested to set
	 */
	public void setCodSocGlRequested(String codSocGlRequested) {
		this.codSocGlRequested = codSocGlRequested;
	}

	public String getBelnr() {
		return belnr;
	}

	public void setBelnr(String belnr) {
		this.belnr = belnr;
	}

	public String getBukrs() {
		return bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public int getGjahr() {
		return gjahr;
	}

	public void setGjahr(int gjahr) {
		this.gjahr = gjahr;
	}

	public String getBuzei() {
		return buzei;
	}

	public void setBuzei(String buzei) {
		this.buzei = buzei;
	}

	public String getBlart() {
		return blart;
	}

	public void setBlart(String blart) {
		this.blart = blart;
	}

	/**
	 * @return the blartLtext
	 */
	public String getBlartLtext() {
		return blartLtext;
	}

	/**
	 * @param blartLtext
	 *            the blartLtext to set
	 */
	public void setBlartLtext(String blartLtext) {
		this.blartLtext = blartLtext;
	}

	public Date getBldat() {
		return bldat;
	}

	public void setBldat(Date bldat) {
		this.bldat = bldat;
	}

	public Date getBudat() {
		return budat;
	}

	public void setBudat(Date budat) {
		this.budat = budat;
	}

	/**
	 * @return the cpudt
	 */
	public Date getCpudt() {
		return cpudt;
	}

	/**
	 * @param cpudt
	 *            the cpudt to set
	 */
	public void setCpudt(Date cpudt) {
		this.cpudt = cpudt;
	}

	public String getXblnr() {
		return xblnr;
	}

	public void setXblnr(String xblnr) {
		this.xblnr = xblnr;
	}

	public String getXref1() {
		return xref1;
	}

	public void setXref1(String xref1) {
		this.xref1 = xref1;
	}

	public String getXref2() {
		return xref2;
	}

	public void setXref2(String xref2) {
		this.xref2 = xref2;
	}

	public String getXref3() {
		return xref3;
	}

	public void setXref3(String xref3) {
		this.xref3 = xref3;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWrbtr() {
		return wrbtr;
	}

	public void setWrbtr(double wrbtr) {
		this.wrbtr = wrbtr;
	}

	public String getWaers() {
		return waers;
	}

	public void setWaers(String waers) {
		this.waers = waers;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getExtKey() {
		return extKey;
	}

	public void setExtKey(String extKey) {
		this.extKey = extKey;
	}

	public String getCaseTitle() {
		return caseTitle;
	}

	public void setCaseTitle(String caseTitle) {
		this.caseTitle = caseTitle;
	}

	/**
	 * @return the differences
	 */
	public String getDifferences() {
		return differences;
	}

	/**
	 * @param differences
	 *            the differences to set
	 */
	public void setDifferences(String differences) {
		this.differences = differences;
	}

	/**
	 * @return the requesterReview
	 */
	public String getRequesterReview() {
		return requesterReview;
	}

	/**
	 * @param requesterReview
	 *            the requesterReview to set
	 */
	public void setRequesterReview(String requesterReview) {
		this.requesterReview = requesterReview;
	}

	/**
	 * @return the intercompanyNote
	 */
	public Note getIntercompanyNote() {
		return intercompanyNote;
	}

	/**
	 * @param intercompanyNote
	 *            the intercompanyNote to set
	 */
	public void setIntercompanyNote(Note intercompanyNote) {
		this.intercompanyNote = intercompanyNote;
	}

	/**
	 * @return the requesterNote
	 */
	public Note getRequesterNote() {
		return requesterNote;
	}

	public Note getRequestedNote() {
		return requestedNote;
	}

	public void setRequestedNote(Note requestedNote) {
		this.requestedNote = requestedNote;
	}

	public String getRequestedReview() {
		return requestedReview;
	}

	public void setRequestedReview(String requestedReview) {
		this.requestedReview = requestedReview;
	}

	/**
	 * @param requesterNote
	 *            the requesterNote to set
	 */
	public void setRequesterNote(Note requesterNote) {
		this.requesterNote = requesterNote;
	}

	public String getDifferencesRequester() {
		return differencesRequester;
	}

	public void setDifferencesRequester(String differencesRequester) {
		this.differencesRequester = differencesRequester;
	}

	public Integer getItemRef() {
		return itemRef;
	}

	public void setItemRef(Integer itemRef) {
		this.itemRef = itemRef;
	}

	public boolean isMultipleRef() {
		return multipleRef;
	}

	public void setMultipleRef(boolean multipleRef) {
		this.multipleRef = multipleRef;
	}

	@Override
	public Object clone() {
		Item clone = new Item();

		return copyProperties(clone);
	}

	protected Object copyProperties(Item clone) {
		clone.setItemId(itemId);
		clone.setCodSocGlRequester(codSocGlRequester);
		clone.setCodSocGlRequested(codSocGlRequested);
		clone.setBelnr(belnr);
		clone.setBukrs(bukrs);
		clone.setGjahr(gjahr);
		clone.setBuzei(buzei);
		clone.setBlart(blart);
		clone.setBlartLtext(blartLtext);
		if (bldat != null) {
			clone.setBldat((Date) bldat.clone());
		}
		if (budat != null) {
			clone.setBudat((Date) budat.clone());
		}
		if (cpudt != null) {
			clone.setCpudt((Date) cpudt.clone());
		}
		clone.setXblnr(xblnr);
		clone.setXref1(xref1);
		clone.setXref2(xref2);
		clone.setXref3(xref3);
		clone.setAccount(account);
		clone.setType(type);
		clone.setWrbtr(wrbtr);
		clone.setWaers(waers);
		clone.setName1(name1);
		clone.setExtKey(extKey);
		clone.setCaseTitle(caseTitle);
		clone.setDifferences(differences);
		clone.setDifferencesRequested(differencesRequested);
		if (intercompanyNote != null) {
			clone.setIntercompanyNote((Note) intercompanyNote.clone());
		}
		clone.setDifferencesRequester(differencesRequester);
		if (intercompanyRequesterNote != null) {
			clone.setIntercompanyRequesterNote((Note) intercompanyRequesterNote.clone());
		}
		clone.setRequesterReview(requesterReview);
		if (requesterNote != null) {
			clone.setRequesterNote((Note) requesterNote.clone());
		}
		clone.setReportSourceId(reportSourceId);
		clone.setReportSourceRel(reportSourceRel);
		clone.setItemRef(itemRef);
		clone.setMultipleRef(multipleRef);

		clone.setTiming(timing);
		clone.setDispute(dispute);
		clone.setFx(fx);
		if (requestedNote != null) {
			clone.setRequestedNote((Note) requestedNote.clone());
		}
		clone.setRequestedReview(requestedReview);
		// clonamos tambien los campos base
		super.copyProperties(clone);
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (belnr == null) {
			if (other.belnr != null)
				return false;
		} else if (!belnr.equals(other.belnr))
			return false;
		if (blart == null) {
			if (other.blart != null)
				return false;
		} else if (!blart.equals(other.blart))
			return false;
		if (blartLtext == null) {
			if (other.blartLtext != null)
				return false;
		} else if (!blartLtext.equals(other.blartLtext))
			return false;
		if (bldat == null) {
			if (other.bldat != null)
				return false;
		} else if (!bldat.equals(other.bldat))
			return false;
		if (budat == null) {
			if (other.budat != null)
				return false;
		} else if (!budat.equals(other.budat))
			return false;
		if (bukrs == null) {
			if (other.bukrs != null)
				return false;
		} else if (!bukrs.equals(other.bukrs))
			return false;
		if (buzei == null) {
			if (other.buzei != null)
				return false;
		} else if (!buzei.equals(other.buzei))
			return false;
		if (caseTitle == null) {
			if (other.caseTitle != null)
				return false;
		} else if (!caseTitle.equals(other.caseTitle))
			return false;
		if (codSocGlRequested == null) {
			if (other.codSocGlRequested != null)
				return false;
		} else if (!codSocGlRequested.equals(other.codSocGlRequested))
			return false;
		if (codSocGlRequester == null) {
			if (other.codSocGlRequester != null)
				return false;
		} else if (!codSocGlRequester.equals(other.codSocGlRequester))
			return false;
		if (cpudt == null) {
			if (other.cpudt != null)
				return false;
		} else if (!cpudt.equals(other.cpudt))
			return false;
		if (differences == null) {
			if (other.differences != null)
				return false;
		} else if (!differences.equals(other.differences))
			return false;
		if (extKey == null) {
			if (other.extKey != null)
				return false;
		} else if (!extKey.equals(other.extKey))
			return false;
		if (gjahr != other.gjahr)
			return false;
		if (intercompanyNote == null) {
			if (other.intercompanyNote != null)
				return false;
		} else if (!intercompanyNote.equals(other.intercompanyNote))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (name1 == null) {
			if (other.name1 != null)
				return false;
		} else if (!name1.equals(other.name1))
			return false;
		if (requesterNote == null) {
			if (other.requesterNote != null)
				return false;
		} else if (!requesterNote.equals(other.requesterNote))
			return false;
		if (requesterReview == null) {
			if (other.requesterReview != null)
				return false;
		} else if (!requesterReview.equals(other.requesterReview))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (waers == null) {
			if (other.waers != null)
				return false;
		} else if (!waers.equals(other.waers))
			return false;
		if (Double.doubleToLongBits(wrbtr) != Double.doubleToLongBits(other.wrbtr))
			return false;
		if (xblnr == null) {
			if (other.xblnr != null)
				return false;
		} else if (!xblnr.equals(other.xblnr))
			return false;
		if (xref1 == null) {
			if (other.xref1 != null)
				return false;
		} else if (!xref1.equals(other.xref1))
			return false;
		if (xref2 == null) {
			if (other.xref2 != null)
				return false;
		} else if (!xref2.equals(other.xref2))
			return false;
		if (xref3 == null) {
			if (other.xref3 != null)
				return false;
		} else if (!xref3.equals(other.xref3))
			return false;
		return true;
	}

	public String getReportSourceId() {
		return reportSourceId;
	}

	public void setReportSourceId(String reportSourceId) {
		this.reportSourceId = reportSourceId;
	}

	public String getReportSourceRel() {
		return reportSourceRel;
	}

	public void setReportSourceRel(String reportSourceRel) {
		this.reportSourceRel = reportSourceRel;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", xref1=" + xref1 + ", xref2=" + xref2 + ", xref3=" + xref3 + ", wrbtr=" + wrbtr + ", waers=" + waers
				+ "]";
	}

	public String getDifferencesRequested() {
		return differencesRequested;
	}

	public void setDifferencesRequested(String differencesRequested) {
		this.differencesRequested = differencesRequested;
	}

	public Note getIntercompanyRequesterNote() {
		return intercompanyRequesterNote;
	}

	public void setIntercompanyRequesterNote(Note intercompanyRequesterNote) {
		this.intercompanyRequesterNote = intercompanyRequesterNote;
	}

	public double getTiming() {
		return timing;
	}

	public void setTiming(double timing) {
		this.timing = timing;
	}

	public double getDispute() {
		return dispute;
	}

	public void setDispute(double dispute) {
		this.dispute = dispute;
	}

	public double getFx() {
		return fx;
	}

	public void setFx(double fx) {
		this.fx = fx;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
