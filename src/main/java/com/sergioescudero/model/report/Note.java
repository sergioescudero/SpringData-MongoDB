package com.sergioescudero.model.report;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable, Cloneable {

	private static final long serialVersionUID = 8081749508918538537L;
	private String note;
	private Date date;
	private String subject;
	private String user;

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Note [note=" + note + ", date=" + date + ", subject=" + subject + ", user=" + user + "]";
	}

	@Override
	public Object clone() {
		Note clone = new Note();
		clone.setNote(note);
		if (date != null) {
			clone.setDate((Date) date.clone());
		}
		clone.setSubject(subject);
		clone.setUser(user);
		return clone;
	}

}
