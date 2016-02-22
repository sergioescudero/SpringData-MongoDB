package com.sergioescudero.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class AuxiliarTable {

	@Id
	private String id;

	private List<KeyValue> data;

	public AuxiliarTable() {
		super();
		this.data = new ArrayList<KeyValue>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<KeyValue> getData() {
		return data;
	}

	public void setData(List<KeyValue> data) {
		this.data = data;
	}
}
