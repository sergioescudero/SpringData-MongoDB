package com.sergioescudero.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemList implements Serializable, Iterable<Item>, Cloneable {

	private static final long serialVersionUID = -6304981893254362215L;
	private List<Item> list = new ArrayList<Item>();

	/*
	 * variable extra para contabilizar a cuantas partidas se les a dado ID y
	 * asi en caso de borrar alguna saber que el el ID que se le da a una nueva
	 * partida no esta siendo utilidado por otra
	 */
	private Integer totalItemId;

	/**
	 * @return the list
	 */
	public List<Item> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Item> list) {
		this.list = list;
	}

	/**
	 * @return the totalItemId
	 */
	public Integer getTotalItemId() {
		return totalItemId;
	}

	/**
	 * @param totalItemId
	 *            the totalItemId to set
	 */
	public void setTotalItemId(Integer totalItemId) {
		this.totalItemId = totalItemId;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Itr();
	}

	@Override
	public Object clone() {
		return clone(false);
	}

	public Object clone(boolean recursive) {
		ItemList itemList = new ItemList();
		if (recursive) {
			itemList.setList(CloneUtils.cloneList(list));
			// List<Item> newlist = new ArrayList<Item>(list.size());
			// for(Item item : list){
			// newlist.add((Item)item.clone());
			// }
			// itemList.setList(newlist);
		} else {
			itemList.setList(new ArrayList<Item>(list));
		}
		itemList.setTotalItemId(totalItemId);
		return itemList;
	}

	private class Itr implements Iterator<Item> {

		int index = 0;
		int cursor = -1;

		@Override
		public boolean hasNext() {
			boolean hashNext = false;
			if (list != null) {
				hashNext = index < list.size();
			}
			return hashNext;
		}

		@Override
		public Item next() {
			Item next = list.get(index);
			cursor = index++;
			return next;
		}

		@Override
		public void remove() {
			if (index == -1) {
				throw new IllegalStateException();
			}
			list.remove(cursor);
			cursor--;
			index--;
		}

	}

	public void clear() {
		list.clear();
	}
}
