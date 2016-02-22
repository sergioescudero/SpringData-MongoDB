package com.sergioescudero.model.report;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CloneUtils {

	protected final static Log logger = LogFactory.getLog(CloneUtils.class);

	private CloneUtils() {
	}

	public static <T extends Cloneable> List<T> cloneList(List<T> list) {
		List<T> clonedList = new ArrayList<T>();
		for (T item : list) {
			T clone;
			try {
				clone = (T) MethodUtils.invokeMethod(item, "clone");
				clonedList.add(clone);
			} catch (Exception e) {
				logger.error("error cloning object " + item.getClass(), e);
				clonedList.add(item);
			}
		}
		return clonedList;
	}
}
