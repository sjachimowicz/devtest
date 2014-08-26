package com.build.devtest;

public class ParentRow extends Person {

	private String parentId;
	
	public ParentRow(String firstName, String lastName, int age, String parentId) {
		super(firstName, lastName, age);
		this.parentId = parentId;
	}

	public String getParentId() {
		return parentId;
	}
}
