package com.model;

import java.io.Serializable;
import java.sql.Date;

public class Merchant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int code;
	String name;
	String lastName;
	Date birtdhay;

	public Merchant(String name, String lastName, Date birtdhay) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birtdhay = birtdhay;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirtdhay() {
		return birtdhay;
	}

	public void setBirtdhay(Date birtdhay) {
		this.birtdhay = birtdhay;
	}

	@Override
	public String toString() {
		return "Merchant [name=" + name + ", lastName=" + lastName + ", birtdhay=" + birtdhay + "]";
	}

	

}
