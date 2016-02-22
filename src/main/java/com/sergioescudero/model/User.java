package com.sergioescudero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class User {

	@Id
	private String id;

	@Field("usuario")
	private String username;

	@Field("lapassword")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(User.class.getSimpleName());

		sb.append(" [");
		for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {

			if (sb.substring(sb.toString().length() - 1) != "[") {
				sb.append(" ");
			}
			field.setAccessible(true);
			String name = field.getName();
			Object value = null;
			try {
				value = field.get(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			sb.append(name + "=" + value);
		}
		sb.append(" ]");

		return sb.toString();
	}
}
